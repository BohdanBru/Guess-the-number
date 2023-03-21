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

package root.console;

import root.model.UserIn;

import java.util.Scanner;

/**
 * @author Bohdan Brukhovets
 * @link https://www.linkedin.com/in/bohdan-brukhovets/
 */
public class UserInConsole implements UserIn {


    @Override
    public int getNumber() {
        Scanner sc = new Scanner(System.in);
        int i = -1;
        try {
            i = sc.nextInt();
        } catch (Exception e) {
            new DatePrinterConsole().fault();
            new DatePrinterConsole().showeInstructions();
            getNumber();

        }


        return i;
    }
}
