/*package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import ru.netology.data.DataCard;
import ru.netology.data.DbHelper;
import ru.netology.page.CardPage;
import ru.netology.page.FirstPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.data.DataGenerator.*;
import static ru.netology.page.CardPage.getErrorNotification;
import static ru.netology.page.CardPage.getSuccessNotification;

public class PaymentUITest {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setUp() {
        DbHelper.cleanDb();
        open(System.getProperty("sut.url"));
    }

    @AfterEach
    void clean() {
        DbHelper.cleanDb();
    }

    //HappyPath
    @Test
    void shouldBuyInPaymentGate() {
        DataCard card = new DataCard(getApprovedNumber(),
                getCurrentMonth(),
                getNextYear(),
                getValidName(),
                getValidCvc());
        new FirstPage().buy();
        new CardPage().fullData(card);
        getSuccessNotification();

        assertEquals(1, DbHelper.getPayments().size());
        assertEquals(0, DbHelper.getCreditsRequest().size());
        assertEquals(1, DbHelper.getOrders().size());

        assertTrue(DbHelper.getPaymentStatus().equalsIgnoreCase("approved"));
        assertEquals(DbHelper.getPayments().get(0).getTransaction_id()
                , DbHelper.getOrders().get(0).getPayment_id());
        assertNull(DbHelper.getOrders().get(0).getCredit_id());
    }

    @Test
    void shouldBuyInPaymentLatinLetters() {
        DataCard card = new DataCard(getApprovedNumber(),
                getCurrentMonth(),
                getNextYear(),
                getValidNameInLatinLetters(),
                getValidCvc());
        new FirstPage().buy();
        val paymentPage = new CardPage();
        paymentPage.fullData(card);
        getSuccessNotification();

        assertEquals(1, DbHelper.getPayments().size());
        assertEquals(0, DbHelper.getCreditsRequest().size());
        assertEquals(1, DbHelper.getOrders().size());
        assertTrue(DbHelper.getPaymentStatus().equalsIgnoreCase("approved"));
        assertEquals(DbHelper.getPayments().get(0).getTransaction_id()
                , DbHelper.getOrders().get(0).getPayment_id());
        assertNull(DbHelper.getOrders().get(0).getCredit_id());
    }

    @Test
    void shouldNotBuyInPaymentDeclinedCardNumber() {
        DataCard card = new DataCard(getDeclinedNumber(),
                getCurrentMonth(),
                getNextYear(),
                getValidName(),
                getValidCvc());
        new FirstPage().buy();
        val paymentPage = new CardPage();
        paymentPage.fullData(card);

        assertEquals("DECLINED", DbHelper.getPaymentStatus());
        getErrorNotification();
    }

    //CardNumber
    @Test
    void shouldInvalidCardNumberErrorNotification() {
        DataCard card = new DataCard(getInvalidCardNumber(),
                getCurrentMonth(),
                getNextYear(),
                getValidName(),
                getValidCvc());
        new FirstPage().buy();
        new CardPage().fullData(card);
        getErrorNotification();
    }

    @Test
    void shouldInvalidFormatShortCardNumber() {
        DataCard card = new DataCard(getShortCardNumber(),
                getCurrentMonth(),
                getNextYear(),
                getValidName(),
                getValidCvc());
        new FirstPage().buy();
        val paymentPage = new CardPage();
        paymentPage.fullData(card);
        paymentPage.getInvalidFormat();
    }

    @Test
    void shouldTheFieldIsRequiredToFillInNumberCard() {
        DataCard card = new DataCard(null,
                getCurrentMonth(),
                getNextYear(),
                getValidName(),
                getValidCvc());
        new FirstPage().buy();
        val paymentPage = new CardPage();
        paymentPage.fullData(card);
        paymentPage.getRequiredField();
    }

    //Month
    @Test
    void shouldInvalidMonthValue_00_PaymentCard() {
        DataCard card = new DataCard(getApprovedNumber(),
                get_OO_Month(),
                getNextYear(),
                getValidName(),
                getValidCvc());
        new FirstPage().buy();
        val paymentPage = new CardPage();
        paymentPage.fullData(card);
        paymentPage.getInvalidDate();
    }

    @Test
    void shouldNonExistingMonth_13() {
        DataCard card = new DataCard(getApprovedNumber(),
                get_13_Month(),
                getNextYear(),
                getValidName(),
                getValidCvc());
        new FirstPage().buy();
        val paymentPage = new CardPage();
        paymentPage.fullData(card);
        paymentPage.getInvalidDate();
    }

    @Test
    void shouldExpiredMonthCard() {
        DataCard card = new DataCard(getApprovedNumber(),
                getLastMonth(),
                getCurrentYear(),
                getValidName(),
                getValidCvc());
        new FirstPage().buy();
        val paymentPage = new CardPage();
        paymentPage.fullData(card);
        paymentPage.getExpiredDateMonth();
    }

    @Test
    void shouldTheFieldIsRequiredToFillInMonthCard() {
        DataCard card = new DataCard(getApprovedNumber(),
                null,
                getNextYear(),
                getValidName(),
                getValidCvc());
        new FirstPage().buy();
        val paymentPage = new CardPage();
        paymentPage.fullData(card);
        paymentPage.getRequiredField();
    }
}*/

