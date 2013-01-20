# no-ae-in-expectations-mode

Demonstration of bug in https://github.com/gar3thjon3s/expectations-mode

# what to do

    git clone https://github.com/dchelimsky/no-ae-in-expectations-mode.git
    cd no-ae-in-expectations-mode
    lein deps
    lein expectations

You should see a java.lang.ArithmeticException.

Now run test/no\_ae\_in\_expectations\_mode/core\_test.clj in emacs using
expectations-mode and you should see "Ran 3 tests, 0 failures, 0 errors"
even though there are 4 expectations and one caused the `ArithmeticException`.
