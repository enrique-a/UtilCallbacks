/*
 * Copyright (C) 2015 Enrique Alonso <enrique.alonso.paez@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package mx.com.enriquealonso.callbacks;

/**
 * A message to be passed from the caller ({@link CallbackCaller}) to the
 * callable ({@link CallbackCallable}). Includes a {@code token} to state the
 * purpuse of the call and a {@code message} with the information.
 *
 * @author Enrique Alonso <enrique.alonso.paez@gmail.com>
 * @param <T> The type of the message to pass, usually {@code Object}.
 */
public class CallbackCall<T> {

    /**
     * The token that identifies the purpuse of the call.
     */
    public final String token;

    /**
     * The information to pass from caller to callable, usually of type
     * {@code Object}.
     */
    public final T message;

    /**
     * Create a new call to pass from caller to callable. Includes a
     * {@code token} to state the purpuse of the call and a {@code message} with
     * the information.
     *
     * @param token The token that identifies the purpuse of the call.
     * @param message The information to pass from caller to callable.
     */
    public CallbackCall(String token, T message) {
        this.token = token;
        this.message = message;
    }

}
