package ru.netology.test;

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

public class CreditUITest {

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
        open(System.getProperty("sut.url"));
    }

    @AfterEach
    void clean() {
        DbHelper.cleanDb();
    }

    //HappyPath


    //Month
    @Test
    void shouldInvalidMonthValue_00_CreditCard() {
        DataCard card = new DataCard(getApprovedNumber(),
                get_OO_Month(),
                getNextYear(),
                getValidName(),
                getValidCvc());
        new FirstPage().buyInCredit();
        val creditPage = new CardPage();
        creditPage.fullData(card);
        creditPage.getInvalidDate();
    }


}
