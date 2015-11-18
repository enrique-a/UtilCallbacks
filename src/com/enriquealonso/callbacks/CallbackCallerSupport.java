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

import java.util.HashSet;
import java.util.function.Predicate;

/**
 * Default implementation of {@link CallbackCaller} to simplify the use of
 * callbacks.
 *
 * @author Enrique Alonso <enrique.alonso.paez@gmail.com>
 * @param <T> The type of the message to send, usually {@code Object}.
 */
public class CallbackCallerSupport<T> implements CallbackCaller<T> {

    /**
     * Registered callables along with their tokens.
     */
    private final HashSet<TokenCallable<T>> callables = new HashSet<>();

    private class TokenCallable<T> {

        public final String token;
        public final CallbackCallable<T> callable;

        public TokenCallable(String token, CallbackCallable<T> callable) {
            this.token = token;
            this.callable = callable;
        }
    }

    @Override
    public void addCallable(String token, CallbackCallable callable) {
        callables.add(new TokenCallable<>(token, callable));
    }

    @Override
    public void removeCallable(final CallbackCallable callable) {
        callables.removeIf(new Predicate<TokenCallable<T>>() {

            @Override
            public boolean test(TokenCallable<T> tc) {
                return callable.equals(tc.callable);
            }
        });
    }

    @Override
    public void removeCallable(final String token) {
        callables.removeIf(new Predicate<TokenCallable<T>>() {

            @Override
            public boolean test(TokenCallable<T> tc) {
                return token.equals(tc.token);
            }
        });
    }

    @Override
    public void callback(CallbackCall<T> call) {
        for (TokenCallable tokenCallable : callables) {
            if (tokenCallable.token == null || tokenCallable.token.equals(call.token)) {
                tokenCallable.callable.call(call);
            }
        }
    }

}
