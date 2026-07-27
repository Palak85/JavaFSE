package commandPattern;

public class CommandTest {
    public static void test() {
        System.out.println("=== Command Pattern Test ===");

        // 1. Create Receiver
        Light livingRoomLight = new Light();

        // 2. Create Concrete Commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // 3. Create Invoker
        RemoteControl remote = new RemoteControl();

        // 4. Test turning Light ON
        System.out.println("--- Action: Pressing Remote ON Button ---");
        remote.setCommand(lightOn);
        remote.pressButton();
        System.out.println();

        // 5. Test turning Light OFF
        System.out.println("--- Action: Pressing Remote OFF Button ---");
        remote.setCommand(lightOff);
        remote.pressButton();
        System.out.println();

        // 6. Test button press without command set
        System.out.println("--- Action: Pressing Button with Empty Slot ---");
        remote.setCommand(null);
        remote.pressButton();
        System.out.println();
    }
}
