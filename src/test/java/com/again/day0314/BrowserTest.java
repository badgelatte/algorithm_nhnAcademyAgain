package com.again.day0314;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.platform.commons.util.ReflectionUtils;

import java.util.Iterator;
import java.util.Stack;


@Slf4j
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class BrowserTest {
    static Browser browser;
    static final String WELCOME_PAGE = "http://nhnacademy.com";
    static final String PAYCO = "http://payco.com";
    static final String HANGAME="http://hangame.com";
    static final String NHN = "http://nhn.com";

    @BeforeAll
    public static void setUp() {
        browser = Browser.of();
    }

    @Test
    @DisplayName("instance of Browser")
    @Order(1)
    void of() {
        Assertions.assertInstanceOf(Browser.class,Browser.of());
    }

    @Test
    @DisplayName("welcome page : http://nhnacademy.com")
    @Order(2)
    void welcomepage() throws Exception {
        Stack<String> backStack = getBackStack();
        Assertions.assertEquals(WELCOME_PAGE, backStack.peek());
    }


    @Test
    @DisplayName("visit")
    @Order(3)
    void visit() {
        Stack<String> forwardStack = getForwardStack();
        Stack<String> backStack = getBackStack();

        String url1 = "http://nhn.com";
        String url2 = "http://payco.com";
        String url3 = "http://hangame.com";

        browser.visit(url1);
        browser.visit(url2);
        browser.visit(url3);

        Assertions.assertAll(
                ()->Assertions.assertEquals(WELCOME_PAGE,backStack.get(0)),
                ()->Assertions.assertEquals(url1, backStack.get(1)),
                ()->Assertions.assertEquals(url2, backStack.get(2)),
                ()->Assertions.assertEquals(url3, backStack.get(3)),
                ()->Assertions.assertTrue(forwardStack.isEmpty())
        );
    }

    @Test
    @Order(4)
    void back_1_1() {
        browser.back(1);

        Stack<String> forwardStack = getForwardStack();
        Stack<String> backStack = getBackStack();

        Assertions.assertAll(
                ()->Assertions.assertEquals(WELCOME_PAGE, backStack.get(0)),
                ()->Assertions.assertEquals("http://nhn.com", backStack.get(1)),
                ()->Assertions.assertEquals("http://payco.com", backStack.get(2)),
                ()->Assertions.assertEquals("http://hangame.com", forwardStack.peek())
        );

    }

    @Test
    @Order(5)
    void back_1_2() {
        browser.back(1);

        Stack<String> forwardStack = getForwardStack();
        Stack<String> backStack = getBackStack();

        Assertions.assertAll(
                ()->Assertions.assertEquals(WELCOME_PAGE, backStack.get(0)),
                ()->Assertions.assertEquals("http://nhn.com", backStack.get(1)),

                ()->Assertions.assertEquals("http://hangame.com", forwardStack.get(0)),
                ()->Assertions.assertEquals("http://payco.com", forwardStack.get(1))
        );

    }

    @Test
    @Order(6)
    void forward_1() {
        browser.forward(1);
        Stack<String> forwardStack = getForwardStack();
        Stack<String> backStack = getBackStack();

        Assertions.assertAll(
                ()->Assertions.assertEquals(WELCOME_PAGE, backStack.get(0)),
                ()->Assertions.assertEquals("http://nhn.com", backStack.get(1)),
                ()->Assertions.assertEquals("http://payco.com", backStack.get(2)),

                ()->Assertions.assertEquals("http://hangame.com", forwardStack.get(0))
        );
    }

    @Test
    @Order(7)
    void forward_2() {
        browser.forward(1);
        Stack<String> forwardStack = getForwardStack();
        Stack<String> backStack = getBackStack();

        Assertions.assertAll(
                ()->Assertions.assertEquals(WELCOME_PAGE, backStack.get(0)),
                ()->Assertions.assertEquals("http://nhn.com", backStack.get(1)),
                ()->Assertions.assertEquals("http://payco.com", backStack.get(2)),
                ()->Assertions.assertEquals("http://hangame.com", backStack.get(3)),

                ()->Assertions.assertTrue(forwardStack.isEmpty())
        );
    }


    private Stack<String> getBackStack(){
        try {
            Stack<String> backStack = (Stack<String>) ReflectionUtils.tryToReadFieldValue(Browser.class,"backStack", browser ).get();
            return backStack;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Stack<String> getForwardStack(){
        try {
            Stack<String> backStack = (Stack<String>) ReflectionUtils.tryToReadFieldValue(Browser.class,"forwardStack", browser ).get();
            return backStack;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @AfterEach
    private void printStack(){
        Stack<String> forwardStack = getForwardStack();
        Stack<String> backStack = getBackStack();

        Iterator<String> backStackiterator = backStack.iterator();
        while (backStackiterator.hasNext()){
            log.info("backStack:{}", backStackiterator.next());
        }

        Iterator<String> forwardIterator = forwardStack.iterator();
        while (forwardIterator.hasNext()){
            log.info("forwardStack:{}", forwardIterator.next());
        }
    }
}