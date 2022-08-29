import com.kodilla.rps.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RpsTestSuite {
    @Mock
    private Rules rulesMock;
    @Mock
    private PlayerInput playerInputMock;

    @Nested
    class testGame {
        @Test
        void testGameWhenPlayerWins() {
            //Given
            try (MockedConstruction<Round> mock = mockConstruction(Round.class, withSettings().defaultAnswer(new Answer() {
                @Override
                public Object answer(InvocationOnMock invocation) throws Throwable {
                    return "Player";
                }
            }))) {
                Game game = new Game("CatLover01", 3, rulesMock, playerInputMock);

                //When
                String result = game.playGame();

                //Then
                assertEquals("Player", result);
            }
        }

        @Test
        void testGameWhenComputerWins() {
            //Given
            try (MockedConstruction<Round> mock = mockConstruction(Round.class, withSettings().defaultAnswer(new Answer() {
                @Override
                public Object answer(InvocationOnMock invocation) throws Throwable {
                    return "Computer";
                }
            }))) {
                Game game = new Game("CatLover01", 3, rulesMock, playerInputMock);

                //When
                String result = game.playGame();

                //Then
                assertEquals("Computer", result);
            }
        }
        @Test
        void testGameWhenDraw(){
            //Given
            int[] rounds = {0};
            try(MockedConstruction<Round> mock = mockConstruction(Round.class, withSettings().defaultAnswer(new Answer() {
                @Override
                public Object answer(InvocationOnMock invocation) throws Throwable {
                    rounds[0]++;
                    if(rounds[0]<5) return "Draw";
                    return "Player";
                }
            }))){
                Game game = new Game("CatLover01", 1, rulesMock, playerInputMock);

                //When
                String result = game.playGame();

                //Then
                assertEquals("Player", result);
            }
        }

        @Test
        void testGameWhenExit() {
            //Given
            try (MockedConstruction<Round> mock = mockConstruction(Round.class, withSettings().defaultAnswer(new Answer() {
                @Override
                public Object answer(InvocationOnMock invocation) throws Throwable {
                    return "Exit";
                }
            }))) {
                Game game = new Game("CatLover01", 3, rulesMock, playerInputMock);

                //When
                String result = game.playGame();

                //Then
                assertEquals("Exit", result);
            }
        }

        @Test
        void testGameWhenNew() {
            //Given
            try (MockedConstruction<Round> mock = mockConstruction(Round.class, withSettings().defaultAnswer(new Answer() {
                @Override
                public Object answer(InvocationOnMock invocation) throws Throwable {
                    return "New";
                }
            }))) {
                Game game = new Game("CatLover01", 3, rulesMock, playerInputMock);

                //When
                String result = game.playGame();

                //Then
                assertEquals("New", result);
            }
        }
    }
    @Nested
    class testRound{

        @Test
        void testRoundWhenPlayerWins(){
            //Given
            List<String> choice = new ArrayList<>();
            choice.add("Scissors");
            choice.add("Scissors");
            choice.add("Scissors");
            when(rulesMock.getDescription()).thenReturn("Drecription");
            when(rulesMock.translateMove("1")).thenReturn("Rock");
            when(rulesMock.getChoice("Rock")).thenReturn(choice);
            when(rulesMock.winsAgainst("Rock")).thenReturn(choice);

            when(playerInputMock.getPlayerInput()).thenReturn("1");

            Round round = new Round(rulesMock, playerInputMock);

            //When
            String result = round.playRound();

            //Then
            assertEquals("Player", result);

        }
        @Test
        void testRoundWhenComputerWins(){
            //Given
            List<String> choice = new ArrayList<>();
            choice.add("Scissors");
            choice.add("Scissors");
            choice.add("Scissors");
            List<String> rule = new ArrayList<>();
            rule.add("Rock");
            rule.add("Rock");
            rule.add("Rock");
            List<String> rule1 = new ArrayList<>();
            rule1.add("Paper");
            rule1.add("Paper");
            rule1.add("Paper");
            when(rulesMock.getDescription()).thenReturn("Drecription");
            when(rulesMock.translateMove("2")).thenReturn("Paper");
            when(rulesMock.getChoice("Paper")).thenReturn(choice);
            when(rulesMock.winsAgainst("Paper")).thenReturn(rule);
            when(rulesMock.winsAgainst("Scissors")).thenReturn(rule1);

            when(playerInputMock.getPlayerInput()).thenReturn("2");

            Round round = new Round(rulesMock, playerInputMock);

            //When
            String result = round.playRound();

            //Then
            assertEquals("Computer", result);

        }
        @Test
        void testRoundWhenDraw(){
            //Given
            List<String> choice = new ArrayList<>();
            choice.add("Scissors");
            choice.add("Scissors");
            choice.add("Scissors");
            List<String> rule = new ArrayList<>();
            rule.add("Paper");
            rule.add("Paper");
            rule.add("Paper");
            when(rulesMock.getDescription()).thenReturn("Drecription");
            when(rulesMock.translateMove("3")).thenReturn("Scissors");
            when(rulesMock.getChoice("Scissors")).thenReturn(choice);
            when(rulesMock.winsAgainst("Scissors")).thenReturn(rule);

            when(playerInputMock.getPlayerInput()).thenReturn("3");

            Round round = new Round(rulesMock, playerInputMock);

            //When
            String result = round.playRound();

            //Then
            assertEquals("Draw", result);

        }
        @Test
        void testRoundWhenExit(){
            //Given
            when(rulesMock.getDescription()).thenReturn("Drecription");

            when(playerInputMock.getPlayerInput())
                    .thenReturn("x")
                    .thenReturn("y");

            Round round = new Round(rulesMock, playerInputMock);

            //When
            String result = round.playRound();

            //Then
            assertEquals("Exit", result);

        }
        @Test
        void testRoundWhenNewGame(){
            //Given
            when(rulesMock.getDescription()).thenReturn("Drecription");

            when(playerInputMock.getPlayerInput())
                    .thenReturn("n")
                    .thenReturn("y");


            Round round = new Round(rulesMock, playerInputMock);

            //When
            String result = round.playRound();

            //Then
            assertEquals("New", result);

        }
    }
    @Nested
    class testRules {
        @Nested
        class testStandardRules {
            @Test
            void testStandardRulesTranslateMove() {
                //Given
                StandardRules standardRules = new StandardRules();

                //When
                String translation1 = standardRules.translateMove("1");
                String translation2 = standardRules.translateMove("2");
                String translation3 = standardRules.translateMove("3");

                //Then
                assertEquals("Rock", translation1);
                assertEquals("Paper", translation2);
                assertEquals("Scissors", translation3);
            }

            @Test
            void testStandardRulesGetChoice() {
                //Given
                StandardRules standardRules = new StandardRules();

                //When
                List<String> rockChoice = new ArrayList<>(standardRules.getChoice("Rock"));
                List<String> paperChoice = new ArrayList<>(standardRules.getChoice("Paper"));
                List<String> scissorsChoice = new ArrayList<>(standardRules.getChoice("Scissors"));
                List<String> expectedChoice = new ArrayList<>();
                expectedChoice.add("Rock");
                expectedChoice.add("Paper");
                expectedChoice.add("Scissors");

                //Then
                assertEquals(expectedChoice, rockChoice);
                assertEquals(expectedChoice, paperChoice);
                assertEquals(expectedChoice, scissorsChoice);
            }

            @Test
            void testStandardRulesWinsAgainst() {
                //Given
                StandardRules standardRules = new StandardRules();

                //When
                List<String> rockWinsAgainst = new ArrayList<>(standardRules.winsAgainst("Rock"));
                List<String> paperWinsAgainst = new ArrayList<>(standardRules.winsAgainst("Paper"));
                List<String> scissorsWinAgainst = new ArrayList<>(standardRules.winsAgainst("Scissors"));

                List<String> rockExpected = new ArrayList<>();
                rockExpected.add("Scissors");
                List<String> paperExpected = new ArrayList<>();
                paperExpected.add("Rock");
                List<String> scissorsExpected = new ArrayList<>();
                scissorsExpected.add("Paper");

                //Then
                assertEquals(rockExpected, rockWinsAgainst);
                assertEquals(paperExpected, paperWinsAgainst);
                assertEquals(scissorsExpected, scissorsWinAgainst);
            }

        }

        @Nested
        class testComputerCheats {
            @Test
            void testComputerCheatsTranslateMove() {
                //Given
                ComputerCheats computerCheats = new ComputerCheats();

                //When
                String translation1 = computerCheats.translateMove("1");
                String translation2 = computerCheats.translateMove("2");
                String translation3 = computerCheats.translateMove("3");

                //Then
                assertEquals("Rock", translation1);
                assertEquals("Paper", translation2);
                assertEquals("Scissors", translation3);
            }

            @Test
            void testComputerCheatsGetChoice() {
                //Given
                ComputerCheats computerCheats = new ComputerCheats();

                //When
                List<String> rockChoice = new ArrayList<>(computerCheats.getChoice("Rock"));
                List<String> paperChoice = new ArrayList<>(computerCheats.getChoice("Paper"));
                List<String> scissorsChoice = new ArrayList<>(computerCheats.getChoice("Scissors"));

                List<String> expectedChoiceRock = new ArrayList<>();
                expectedChoiceRock.add("Rock");
                expectedChoiceRock.add("Paper");
                expectedChoiceRock.add("Paper");
                expectedChoiceRock.add("Scissors");
                List<String> expectedChoicePaper = new ArrayList<>();
                expectedChoicePaper.add("Rock");
                expectedChoicePaper.add("Paper");
                expectedChoicePaper.add("Scissors");
                expectedChoicePaper.add("Scissors");
                List<String> expectedChoiceScissors = new ArrayList<>();
                expectedChoiceScissors.add("Rock");
                expectedChoiceScissors.add("Rock");
                expectedChoiceScissors.add("Paper");
                expectedChoiceScissors.add("Scissors");

                //Then
                assertEquals(expectedChoiceRock, rockChoice);
                assertEquals(expectedChoicePaper, paperChoice);
                assertEquals(expectedChoiceScissors, scissorsChoice);
            }

            @Test
            void testComputerCheatsWinsAgainst() {
                //Given
                ComputerCheats computerCheats = new ComputerCheats();

                //When
                List<String> rockWinsAgainst = new ArrayList<>(computerCheats.winsAgainst("Rock"));
                List<String> paperWinsAgainst = new ArrayList<>(computerCheats.winsAgainst("Paper"));
                List<String> scissorsWinAgainst = new ArrayList<>(computerCheats.winsAgainst("Scissors"));

                List<String> rockExpected = new ArrayList<>();
                rockExpected.add("Scissors");
                List<String> paperExpected = new ArrayList<>();
                paperExpected.add("Rock");
                List<String> scissorsExpected = new ArrayList<>();
                scissorsExpected.add("Paper");

                //Then
                assertEquals(rockExpected, rockWinsAgainst);
                assertEquals(paperExpected, paperWinsAgainst);
                assertEquals(scissorsExpected, scissorsWinAgainst);
            }


        }
        @Nested
        class testExoticRules {
            @Test
            void testExoticRulesTranslateMove() {
                //Given
                ExoticRules exoticRules = new ExoticRules();

                //When
                String translation1 = exoticRules.translateMove("1");
                String translation2 = exoticRules.translateMove("2");
                String translation3 = exoticRules.translateMove("3");
                String translation4 = exoticRules.translateMove("4");
                String translation5 = exoticRules.translateMove("5");

                //Then
                assertEquals("Rock", translation1);
                assertEquals("Paper", translation2);
                assertEquals("Scissors", translation3);
                assertEquals("Lizard", translation4);
                assertEquals("Spock", translation5);
            }

            @Test
            void testExoticRulesGetChoice() {
                //Given
                ExoticRules exoticRules = new ExoticRules();

                //When
                List<String> rockChoice = new ArrayList<>(exoticRules.getChoice("Rock"));
                List<String> paperChoice = new ArrayList<>(exoticRules.getChoice("Paper"));
                List<String> scissorsChoice = new ArrayList<>(exoticRules.getChoice("Scissors"));
                List<String> lizardChoice = new ArrayList<>(exoticRules.getChoice("Lizard"));
                List<String> spockChoice = new ArrayList<>(exoticRules.getChoice("Spock"));
                List<String> expectedChoice = new ArrayList<>();
                expectedChoice.add("Rock");
                expectedChoice.add("Paper");
                expectedChoice.add("Scissors");
                expectedChoice.add("Lizard");
                expectedChoice.add("Spock");

                //Then
                assertEquals(expectedChoice, rockChoice);
                assertEquals(expectedChoice, paperChoice);
                assertEquals(expectedChoice, scissorsChoice);
                assertEquals(expectedChoice, lizardChoice);
                assertEquals(expectedChoice, spockChoice);
            }

            @Test
            void testExoticRulesWinsAgainst() {
                //Given
                ExoticRules exoticRules = new ExoticRules();

                //When
                List<String> rockWinsAgainst = new ArrayList<>(exoticRules.winsAgainst("Rock"));
                List<String> paperWinsAgainst = new ArrayList<>(exoticRules.winsAgainst("Paper"));
                List<String> scissorsWinAgainst = new ArrayList<>(exoticRules.winsAgainst("Scissors"));
                List<String> lizardWinsAgainst = new ArrayList<>(exoticRules.winsAgainst("Lizard"));
                List<String> spockWinsAgainst = new ArrayList<>(exoticRules.winsAgainst("Spock"));

                List<String> rockExpected = new ArrayList<>();
                rockExpected.add("Scissors");
                rockExpected.add("Lizard");
                List<String> paperExpected = new ArrayList<>();
                paperExpected.add("Rock");
                paperExpected.add("Spock");
                List<String> scissorsExpected = new ArrayList<>();
                scissorsExpected.add("Paper");
                scissorsExpected.add("Lizard");
                List<String> lizardExpected = new ArrayList<>();
                lizardExpected.add("Paper");
                lizardExpected.add("Spock");
                List<String> spockExpected = new ArrayList<>();
                spockExpected.add("Rock");
                spockExpected.add("Scissors");

                //Then
                assertEquals(rockExpected, rockWinsAgainst);
                assertEquals(paperExpected, paperWinsAgainst);
                assertEquals(scissorsExpected, scissorsWinAgainst);
                assertEquals(lizardExpected, lizardWinsAgainst);
                assertEquals(spockExpected, spockWinsAgainst);
            }

        }

    }
}
