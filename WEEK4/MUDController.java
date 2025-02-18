import java.util.Scanner;
public class MUDController {
    private final Player player;
    private boolean running;
    private final CommandHandler commandHandler;

    public MUDController(Player player) {
        this.player = player;
        this.running = true;
        this.commandHandler = new CommandHandler(player, this);
    }

    public void runGameLoop() {
        Scanner scanner = new Scanner(System.in);
        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();
            commandHandler.handleInput(input);
        }
        scanner.close();
    }

    public void stopGame() {
        running = false;
        System.out.println("Exiting game...");
    }
}
