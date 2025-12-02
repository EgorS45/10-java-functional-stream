package com.example.task03;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        Objects.requireNonNull(stream);
        Objects.requireNonNull(order);
        Objects.requireNonNull(minMaxConsumer);

        class MinMaxHolder {
            T min;
            T max;
            boolean initialized;

            void accept(T value) {
                if (!initialized) {
                    min = value;
                    max = value;
                    initialized = true;
                } else {
                    if (order.compare(value, min) < 0) {
                        min = value;
                    }
                    if (order.compare(value, max) > 0) {
                        max = value;
                    }
                }
            }

            MinMaxHolder combine(MinMaxHolder other) {
                if (!other.initialized) {
                    return this;
                } else if (!initialized) {
                    return other;
                }
                accept(other.min);
                accept(other.max);
                return this;
            }
        }

        MinMaxHolder result = stream.collect(MinMaxHolder::new, MinMaxHolder::accept, MinMaxHolder::combine);

        minMaxConsumer.accept(result.min, result.max);
    }
}
