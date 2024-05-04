package algorithms.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PlaygroundTest {
    private Playground playgroundMock;

    @BeforeEach
    void setUp() {
        playgroundMock = mock(Playground.class);

    }

    @Test
    void sum() {
        Playground myPlayground = new Playground("myPlayground");
        assertEquals(4, myPlayground.sum(2,2));
    }
}

/*
    @BeforeEach
    void setUp() {
        playgroundMock = mock(Playground.class);
        Playground myPlayground = new Playground("myPlayground");
    }

    @Test
    void sum() {
        assertEquals(true,true);
    }

 */