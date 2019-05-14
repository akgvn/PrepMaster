<?php

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

    return $new_easiness;
}

function interval($n, $easiness, $old_interv)
{
    if ($n == 1) {
        return 1;
    } elseif ($n == 2) {
        return 6;
    } elseif ($n > 2) {
        $interv = $old_interv * $easiness;
        return $interv;
    }
}
