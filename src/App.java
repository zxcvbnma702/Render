public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        Display window = new Display(800, 600, "Software Render");

        while(true)
        {
            window.SwapBuffers();
        }
    }
}
