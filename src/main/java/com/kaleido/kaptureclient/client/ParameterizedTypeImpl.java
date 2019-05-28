package com.kaleido.kaptureclient.client;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Allows a Type Token for a Generic Type
 * @see <a href="http://gafter.blogspot.com/2006/12/super-type-tokens.html"> Super Type Tokens</a>
 * @see <a href="https://stackoverflow.com/q/21987295/3573553">Stack overflow solution</a>
 */
public class ParameterizedTypeImpl implements ParameterizedType {
    private ParameterizedType delegate;
    private Type[] actualTypeArguments;

    ParameterizedTypeImpl(ParameterizedType delegate, Type[] actualTypeArguments) {
        this.delegate = delegate;
        this.actualTypeArguments = actualTypeArguments;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return actualTypeArguments;
    }

    @Override
    public Type getRawType() {
        return delegate.getRawType();
    }

    @Override
    public Type getOwnerType() {
        return delegate.getOwnerType();
    }

}
