package DependencyInversion;

import java.security.Key;

interface Keyboard {
}

class WiredKeyboard implements Keyboard {
}

class WirelessKeyboard implements Keyboard {
}

interface Mouse {
}

class WiredMouse implements Mouse {
}

class WirelessMouse implements Mouse {
}

// here in Macbook class, we are using concrete class, not Macbook keyboard needs to be wired, and mouse needs to be wired
class Macbook {
    private final WiredKeyboard keyboard;
    private final WiredMouse mouse;

    public Macbook() {
        keyboard = new WiredKeyboard();
        mouse = new WiredMouse();
    }
}


// FixMacbook mein class hardcoded nhi hai, instead we are using interface
class FixMacbook {
    private final Keyboard keyboard;
    private final Mouse mouse;

    public FixMacbook(Keyboard keyboard, Mouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
}

class Test {
    WiredKeyboard k1 = new WiredKeyboard();
    WiredMouse m1 = new WiredMouse();

    WirelessKeyboard k2 = new WirelessKeyboard();
    WirelessMouse m2 = new WirelessMouse();

    // here we created wired keyboard and wired mouse
    FixMacbook fm1 = new FixMacbook(k1, m1);

    // here we created wireless keyboard and wireless mouse
    FixMacbook fm2 = new FixMacbook(k2, m2);

    // here we can only create wired keyboard and wired mouse (check constructor for Macbook class)
    Macbook m = new Macbook();
}