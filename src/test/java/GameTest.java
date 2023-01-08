import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.COLLECTIONS.Game;
import ru.netology.COLLECTIONS.NotRegisteredException;
import ru.netology.COLLECTIONS.Player;

public class GameTest {

    @Test
    public void registerTest() {
        Game game = new Game();
        Player actualPlayer = new Player(1,"Kosta", 10);
        game.register(actualPlayer);
        Player expectedPlayer = actualPlayer;
        assertEquals(expectedPlayer, actualPlayer);

        // Повторная регистрация игрока

        actualPlayer = game.register(actualPlayer);
        expectedPlayer = null;
        assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    public void roundTest1() {
        // Если победить должен игрок 1
        Game game = new Game();
        Player player1 = new Player(1, "Kosta", 10);
        Player player2 = new Player(2, "Vasya", 5);
        game.register(player1);
        game.register(player2);
        int exception = 1;
        int actual = game.round("Kosta", "Vasya");
        assertEquals(exception, actual);
    }

    @Test
    public void roundTest2() {
        // Если победить должен игрок 2
        Game game = new Game();
        Player player1 = new Player(1, "Kosta", 5);
        Player player2 = new Player(2, "Vasya", 10);
        game.register(player1);
        game.register(player2);
        int exception = 2;
        int actual = game.round("Kosta", "Vasya");
        assertEquals(exception, actual);
    }

    @Test
    public void roundTest3() {
        // Если должна быть ничья
        Game game = new Game();
        Player player1 = new Player(1, "Kosta", 10);
        Player player2 = new Player(2, "Vasya", 10);
        game.register(player1);
        game.register(player2);
        int exception = 0;
        int actual = game.round("Kosta", "Vasya");
        assertEquals(exception, actual);
    }

    @Test
    public void roundNotRegisteredExceptionTest1() {
        // Если игрок 1 не зарегистрирован
        Game game = new Game();
        Player player1 = new Player(1, "Kosta", 10);
        Player player2 = new Player(2, "Vasya", 10);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Kosta", "Vasya");
        });
    }

    @Test
    public void roundNotRegisteredExceptionTest2() {
        // Если игрок 2 не зарегистрирован
        Game game = new Game();
        Player player1 = new Player(1, "Kosta", 10);
        Player player2 = new Player(2, "Vasya", 10);
        game.register(player1);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Kosta", "Vasya");
        });
    }

    @Test
    public void roundNotRegisteredExceptionTest3() {
        // Если оба игрока не зарегистрированы
        Game game = new Game();
        Player player1 = new Player(1, "Kosta", 10);
        Player player2 = new Player(2, "Vasya", 10);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Kosta", "Vasya");
        });
    }
}
