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

    @Test
    void mockingLearning() {
        //You can mock concrete classes, not just interfaces
        LinkedList mockedList = mock(LinkedList.class);

        //EXAMPLE 1: Stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new NullPointerException());
        assertThrows(NullPointerException.class, () -> mockedList.get(1));
        //when(mockedList.get(1)).thenThrow(new RuntimeException());
        //assertThrows(RuntimeException.class, () -> mockedList.get(1));

        //EXAMPLE 2:
        when(playgroundMock.sum(2,2)).thenReturn(4);
        Integer answer = playgroundMock.sum(2,2);
        assertEquals(4,answer);
    }


    @org.junit.Test
    void callSum() {
        //This will NOT call real method
        when(playgroundMock.sum(2,2)).thenReturn(4);
        Integer answerMock = playgroundMock.sum(2,2);
        assertEquals(4,answerMock);

        //This will call real method
        Playground callRealSumPlayground = new Playground("myPlayground");
        Integer answer = callRealSumPlayground.sum(2,2);
        assertEquals(4,answer);
    }


    @Test
    void learnVerify() {
        //Verify is to check if a mock was called
        //So I have RealUser calls mockDatabaseClass.getGroups. I fake the return but make sure this was called

        //TYPE 1: List
        List<String> mockList = mock(List.class);
        mockList.add("frodo");
        mockList.add("sam");
        mockList.size();

        verify(mockList).add("frodo");
        verify(mockList).add("sam");

        verify(mockList, times(1)).size();


        //TYPE 2: Playground
        Playground learnVerifyMock = mock(Playground.class);
        learnVerifyMock.sum(2,2);
        verify(learnVerifyMock).sum(2,2);
        //This sum(2,3) is different so it wont work
        //verify(learnVerifyMock, times(1)).sum(2,3);
        verify(learnVerifyMock, times(1)).sum(2,2);

    }

    @Test
    void learnSpy() {
        //Example 1: Linked List
        List list = new LinkedList();
        List spy = spy(list);

        when(spy.size()).thenReturn(100);

        //using the spy calls *real* methods
        spy.add("one");
        spy.add("two");

        System.out.println(spy.get(0));
        System.out.println(spy.size());

        verify(spy).add("one");
        verify(spy).add("two");
    }


}
