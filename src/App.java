public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        Display window = new Display(800, 600, "Software Render");
        Bitmap target = window.GetFrameBuffer();
        Stars3D stars = new Stars3D(4096, 64.0f, 20.0f);


        long previousTime = System.nanoTime();

        while(true)
        {
            long currentTime = System.nanoTime();
            float delta = (float)((currentTime - previousTime) / 1000000000.0);
            previousTime = currentTime;

            target.Clear((byte)0x00);
            // stars.UpdateAndRender(target, delta);

            window.SwapBuffers();
        }
    }
}
