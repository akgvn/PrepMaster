<?php


/*
        Split the knowledge into smallest possible items.
        With all items associate an E-Factor equal to 2.5.
        Repeat items using the following intervals:
        I(1):=1
        I(2):=6
        for n>2: I(n):=I(n-1)*EF
        where:
        I(n) - inter-repetition interval after the n-th repetition (in days),
        EF - E-Factor of a given item
        If interval is a fraction, round it up to the nearest integer.

        After each repetition assess the quality of repetition response in 0-5 grade scale:
        5 - perfect response
        4 - correct response after a hesitation
        3 - correct response recalled with serious difficulty
        2 - incorrect response; where the correct one seemed easy to recall
        1 - incorrect response; the correct one remembered
        0 - complete blackout.

        After each repetition modify the E-Factor of the recently repeated item according to the formula:
        EF':=EF+(0.1-(5-q)*(0.08+(5-q)*0.02))
        where:
        EF' - new value of the E-Factor,
        EF - old value of the E-Factor,
        q - quality of the response in the 0-5 grade scale.

        If EF is less than 1.3 then let EF be 1.3.
        If the quality response was lower than 3 then start repetitions for the item from the beginning without changing the E-Factor (i.e. use intervals I(1), I(2) etc. as if the item was memorized anew).
        After each repetition session of a given day repeat again all items that scored below four in the quality assessment. Continue the repetitions until all of these items score at least four.
*/


function easiness($old_easiness, $response_quality)
{
    // Easiness factor reflects the easiness of memorizing and retaining a given item in memory

    // EF':=EF-0.8+0.28*q-0.02*q*q

    if ($response_quality == 4) {
        return $old_easiness;
    }

    $new_easiness = $old_easiness - 0.8;

    $operand = $response_quality * 0.28;

    $operand -= $response_quality * $response_quality * 0.02;

    $new_easiness += $operand;

    if ($new_easiness < 1.3) {
        $new_easiness = 1.3;
    }

    return $new_easiness;
}

function interval($n, $easiness, $old_interv)
{
    // Returns number of days for scheduling.
    if ($n == 1) {
        return 1;
    } elseif ($n == 2) {
        return 6;
    } elseif ($n > 2) {
        $interv = $old_interv * $easiness;
        $interv = ceil($interv);
        return $interv;
    }
}