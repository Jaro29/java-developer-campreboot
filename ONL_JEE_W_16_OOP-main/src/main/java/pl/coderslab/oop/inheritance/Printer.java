package pl.coderslab.oop.inheritance;


class Printer extends Device {
    private int tonerLevel = 100; // Poziom tonera w %

//    public Printer() {
//        super();
//        setTonerLevel(tonerLevel);
//    }

//    public int getTonerLevel() {
//        return tonerLevel;
//    }

    @Override
    public void runSelfTest() {
        System.out.println("Checking printer. Toner level: " + tonerLevel + "%");
    }

    @Override
    public String toString() {
        return "Printers toner level: " + tonerLevel;
    }

//    public void setTonerLevel(int tonerLevel) {
//        this.tonerLevel = tonerLevel;
//    }
}