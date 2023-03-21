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

package root;

import root.argumentParser.ArgumentParser;
import root.console.DatePrinterConsole;
import root.console.FinishConsole;
import root.console.UserInConsole;
import root.gui.GameWindow;
import root.model.*;

import static root.model.Mode.GUI;

/**
 * @author Bohdan Brukhovets
 * @link https://www.linkedin.com/in/bohdan-brukhovets/
 */
public class GameFactory {
    public Game create(String[] arg) {
        final DatePrinter datePrinter;
        final Finish finish;
        final UserIn userIn;
        Mode mode = new ArgumentParser(arg).parser();
        if (mode.equals(GUI)) {
            GameWindow window = new GameWindow();
            datePrinter = window;
            finish = window;
            userIn = window;
            Game game = new Game(userIn, datePrinter, finish, new RandomNumber());
            return game;
        } else {
            datePrinter = new DatePrinterConsole();
            finish = new FinishConsole();
            userIn = new UserInConsole();
            Game game = new Game(userIn, datePrinter, finish, new RandomNumber());
            return game;
        }
    }
}
