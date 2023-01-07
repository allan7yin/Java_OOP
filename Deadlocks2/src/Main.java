public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        Display display = new Display();
        data.setDisplay(display);
        display.setData(data);
    }

    private static class Data {
        private Display display;
        public void setDisplay(Display display) {
            this.display = display;
        }

        public synchronized void updateData() {
            System.out.println("Updating data ...");
            display.dataChanged();
        }

        public synchronized Object getData() {
            return new Object();
        }
    }

    private static class Display {
        private Data data;
        public void setData(Data data) {
            this.data = data;
        }

        public synchronized void dataChanged() {
            System.out.println("I'm doing something because the data changed");
        }

        public synchronized void updateDisplay() {
            System.out.println("Updating display ...");
            Object o = data.getData();
        }
    }
}

