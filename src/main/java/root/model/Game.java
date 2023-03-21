/*
 * Copyright 2023 Bohdan Brukhovets
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package root.model;

/**
 * @author Bohdan Brukhovets
 * @link https://www.linkedin.com/in/bohdan-brukhovets/
 */

public class Game {
    private final UserIn userIn;
    private final DatePrinter datePrinter;
    private final Finish finish;
    RandomNumber rundomNumber;


    public Game(UserIn userIn, DatePrinter datePrinter, Finish finish, RandomNumber rundomNumber) {
        this.userIn = userIn;
        this.datePrinter = datePrinter;
        this.finish = finish;
        this.rundomNumber = rundomNumber;
    }


    public void startGame() {


        datePrinter.showeInstructions();

        rundomNumber.getNumber();
        while (true) {
            int userNumber = userIn.getNumber();

            if (userNumber > 9 || userNumber < 0) {
                datePrinter.fault();
                startGame();
            }

            if (userNumber == rundomNumber.number) {
                datePrinter.win();
                finish.end();
            } else if (userNumber > rundomNumber.number) {
                datePrinter.bigger(userNumber);
            } else if (userNumber < rundomNumber.number) {
                datePrinter.less(userNumber);
            } else datePrinter.fault();
        }

    }
}
