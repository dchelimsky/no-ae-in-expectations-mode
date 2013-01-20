(ns no-ae-in-expectations-mode.core-test
  (:use expectations))

;; attempted solution to http://www.4clojure.com/problem/147

(defn pascals-trapezoid [v]
  (lazy-seq
   (cons v
         (pascals-trapezoid (->> (concat [0] v [0]) (partition 2 1) (map (partial apply +)))))))

(expect [2 5 5 2] (second (pascals-trapezoid [2 3 2])))

(expect [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]] (take 5 (pascals-trapezoid [1])))

(expect [[3 1 2] [3 4 3 2]] (take 2 (pascals-trapezoid [3 1 2])))

(expect (rest (take 101 (pascals-trapezoid [2 2]))) (take 100 (pascals-trapezoid [2 4 2])))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; when run in emacs using expectations-mode, mini-buffer displays:
;;
;;    Ran 3 tests, 0 failures, 0 errors
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; if nrepl buffer is open, you can see:
;;
;;   unexpected exception in no-ae-in-expectations-mode.core-test:17
;;
;;   Ran 4 tests containing 3 assertions in 24 msecs
;;   0 failures, 0 errors.
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; on command line you see:
;;
;;   $ lein expectations
;;
;;   unexpected exception in no-ae-in-expectations-mode.core-test:17
;;   java.lang.ArithmeticException: integer overflow
;;
;;   Ran 4 tests containing 3 assertions in 45 msecs
;;   0 failures, 0 errors.
;;      at clojure.lang.Numbers.throwIntOverflow(Numbers.java:1388)
;;      at clojure.lang.Numbers.add(Numbers.java:1687)
;;      at clojure.lang.Numbers$LongOps.add(Numbers.java:430)
;;      at clojure.lang.Numbers.add(Numbers.java:126)
;;      at clojure.core$_PLUS_.invoke(core.clj:928)
;;      at clojure.lang.AFn.applyToHelper(AFn.java:163)
;;      at clojure.lang.RestFn.applyTo(RestFn.java:132)
;;      at clojure.core$apply.invoke(core.clj:601)
;;      at clojure.lang.AFn.applyToHelper(AFn.java:163)
;;      at clojure.lang.RestFn.applyTo(RestFn.java:132)
;;      at clojure.core$apply.invoke(core.clj:603)
;;      at clojure.core$partial$fn__4070.doInvoke(core.clj:2343)
;;      at clojure.lang.RestFn.invoke(RestFn.java:408)
;;      at clojure.core$map$fn__4087.invoke(core.clj:2434)
;;      at clojure.lang.LazySeq.sval(LazySeq.java:42)
;;      at clojure.lang.LazySeq.seq(LazySeq.java:60)
;;      at clojure.lang.Cons.next(Cons.java:39)
;;      at clojure.lang.ASeq.equiv(ASeq.java:40)
;;      at clojure.lang.LazySeq.equals(LazySeq.java:131)
;;      at clojure.lang.LazySeq.equiv(LazySeq.java:111)
;;      at clojure.lang.Util.pcequiv(Util.java:79)
;;      at clojure.lang.Util.equiv(Util.java:31)
;;      at clojure.lang.ASeq.equiv(ASeq.java:42)
;;      at clojure.lang.LazySeq.equals(LazySeq.java:131)
;;      at clojure.lang.LazySeq.equiv(LazySeq.java:111)
;;      at clojure.lang.Util.pcequiv(Util.java:79)
;;      at clojure.lang.Util.equiv(Util.java:31)
;;      at expectations$eval327$fn__328.invoke(expectations.clj:480)
;;      at clojure.lang.MultiFn.invoke(MultiFn.java:177)
;;      at no_ae_in_expectations_mode.core_test$G__569.invoke(core_test.clj:17)
;;      at expectations$test_var$fn__127.invoke(expectations.clj:212)
;;      at expectations$test_var.invoke(expectations.clj:208)
;;      at expectations$test_vars.invoke(expectations.clj:244)
;;      at expectations$run_tests.invoke(expectations.clj:271)
;;      at expectations$run_all_tests.invoke(expectations.clj:275)
;;      at user$eval577.invoke(NO_SOURCE_FILE:1)
;;      at clojure.lang.Compiler.eval(Compiler.java:6511)
;;      at clojure.lang.Compiler.eval(Compiler.java:6500)
;;      at clojure.lang.Compiler.eval(Compiler.java:6501)
;;      at clojure.lang.Compiler.eval(Compiler.java:6477)
;;      at clojure.core$eval.invoke(core.clj:2797)
;;      at clojure.main$eval_opt.invoke(main.clj:297)
;;      at clojure.main$initialize.invoke(main.clj:316)
;;      at clojure.main$null_opt.invoke(main.clj:349)
;;      at clojure.main$main.doInvoke(main.clj:427)
;;      at clojure.lang.RestFn.invoke(RestFn.java:421)
;;      at clojure.lang.Var.invoke(Var.java:419)
;;      at clojure.lang.AFn.applyToHelper(AFn.java:163)
;;      at clojure.lang.Var.applyTo(Var.java:532)
;;      at clojure.main.main(main.java:37)
