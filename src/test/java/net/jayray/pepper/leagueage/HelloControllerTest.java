package net.jayray.pepper.leagueage;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class HelloControllerTest {
    private final HelloController hello = new HelloController();

    @Test
    public void getHello() {
        assertEquals("hello world!", hello.sayHello(Optional.empty()));
    }

    @Test
    public void getHelloWithName() {
        assertEquals("hello pepper!", hello.sayHello(Optional.of("pepper")));
    }
}