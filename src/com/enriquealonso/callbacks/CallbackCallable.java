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
 * An interface to receive calls ({@link CallbackCall}) from a caller
 * ({@link CallbackCaller}).
 *
 * @author Enrique Alonso <enrique.alonso.paez@gmail.com>
 * @param <T> The type of the message to receive, usually {@code Object}.
 */
public interface CallbackCallable<T> {

    /**
     * Receives a call, which includes a {@code token} to identify the purpose of
     * the call and a {@code message} from the caller.
     *
     * @param call
     */
    public void call(CallbackCall<T> call);

}
