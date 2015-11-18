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
 * An interface to register callables ({@link CallbackCallable}) and callback
 * them with a message.
 *
 * @author Enrique Alonso <enrique.alonso.paez@gmail.com>
 * @param <T> The type of the message to send, usually {@code Object}.
 */
public interface CallbackCaller<T> {

    /**
     * Add a callable ({@link CallbackCallable}) for a specific {@code token}.
     *
     * @param token The token that identifies the purpuse of the call.
     * @param callable The {@link CallbackCallable} that is going to receive
     * calls.
     */
    public void addCallable(String token, CallbackCallable<T> callable);

    /**
     * Removes all ocurrences of {@link CallbackCallable} for any {@code token}.
     *
     * @param callable The {@link CallbackCallable} whose ocurrences are going
     * to be removed.
     */
    public void removeCallable(CallbackCallable<T> callable);

    /**
     * Removes all ocurrences of {@code token} for any {@link CallbackCallable}.
     *
     * @param token The {@code token} whose ocurrences are going to be removed.
     */
    public void removeCallable(String token);

    /**
     * Makes a call to every callable registered with the apropriate token
     * ({@link CallbackCallable#call}).
     * A registered callable is called if its token is {@code null} or is equal
     * to the token in the call.
     *
     * @param call The call with with a {@code token} to identify the purpose of
     * the call and a {@code message} to be passed to all the appropriate
     * callables.
     */
    public void callback(CallbackCall<T> call);

}
