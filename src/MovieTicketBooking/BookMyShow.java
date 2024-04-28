package MovieTicketBooking;

import MovieTicketBooking.Enums.City;
import MovieTicketBooking.Enums.SeatCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;

    BookMyShow() {
        this.movieController = new MovieController();
        this.theatreController = new TheatreController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();

        bookMyShow.createBooking(City.Bangalore, "Bahubali");
        bookMyShow.createBooking(City.Bangalore, "Bahubali");
    }

    private void createBooking(City city, String movieName) {
        // search movie by location
        List<Movie> movies = movieController.getMoviesByCity(city);
        Movie bookMovie = null;

        // select movie which we want to book
        for (Movie movie : movies) {
            if (movie.getMovieName().equals(movieName)) {
                bookMovie = movie;
            }
        }

        // if bookmovie is null return

        // get all show of bookmovie in city
        Map<Theatre, List<Show>> theatreShowsMap = theatreController.getAllShow(bookMovie, city);

        Map.Entry<Theatre, List<Show>> entry = theatreShowsMap.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();

        Show interestedShow = runningShows.get(0);
        int seatNumber = 30;

        List<Integer> bookedSeats = interestedShow.getBookedSeatIds();
        if (!bookedSeats.contains(seatNumber)) {
            bookedSeats.add(seatNumber);
            //startPayment
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for (Seat screenSeat : interestedShow.getScreen().getSeatsList()) {
                if (screenSeat.getSeatId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");
    }

    private void initialize() {
        createMovies();
        createTheater();
    }

    private void createTheater() {
        Movie humSaathMovie = movieController.getMovieByName("Hum Saath Saath hai");
        Movie baahubaliMovie = movieController.getMovieByName("Bahubali");
        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setThreaterId(1);
        inoxTheatre.setScreenList(createScreen());
        inoxTheatre.setCity(City.Bangalore);

        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShows(1, inoxTheatre.getScreenList().get(0), baahubaliMovie, 8);
        Show inoxEveningShow = createShows(2, inoxTheatre.getScreenList().get(0), humSaathMovie, 16);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxTheatre.setShowsList(inoxShows);


        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setThreaterId(2);
        pvrTheatre.setScreenList(createScreen());
        pvrTheatre.setCity(City.Delhi);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(3, pvrTheatre.getScreenList().get(0), humSaathMovie, 13);
        Show pvrEveningShow = createShows(4, pvrTheatre.getScreenList().get(0), baahubaliMovie, 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShowsList(pvrShows);

        theatreController.addTheatre(inoxTheatre, City.Bangalore);
        theatreController.addTheatre(pvrTheatre, City.Delhi);
    }

    private Show createShows(int showId, Screen screen, Movie movie, int showStartTime) {

        Show show = new Show();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setShowStartTime(showStartTime); //24 hrs time ex: 14 means 2pm and 8 means 8AM
        return show;
    }

    private List<Screen> createScreen() {

        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setSeatsList(createSeats());
        screens.add(screen1);

        Screen screen2 = new Screen();
        screen2.setScreenId(2);
        screen2.setSeatsList(createSeats());
        screens.add(screen1);

        return screens;
    }

    private List<Seat> createSeats() {

        List<Seat> seats = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seats.add(seat);
        }

        for (int i = 40; i < 70; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }

        //1 to 40 : SILVER
        for (int i = 70; i < 100; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }

        return seats;
    }

    private void createMovies() {
        Movie movie_one = new Movie();
        movie_one.setMovieId(1);
        movie_one.setMovieName("Bahubali");
        movie_one.setMovieDurationInMinutes(180);

        Movie movie_two = new Movie();
        movie_two.setMovieId(2);
        movie_two.setMovieName("Hum Saath Saath hai");
        movie_two.setMovieDurationInMinutes(140);


        //add movies against the cities
        movieController.addMovie(movie_two, City.Bangalore);
        movieController.addMovie(movie_two, City.Delhi);
        movieController.addMovie(movie_one, City.Bangalore);
        movieController.addMovie(movie_one, City.Delhi);
    }
}
