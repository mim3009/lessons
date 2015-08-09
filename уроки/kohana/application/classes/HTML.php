<?php defined('SYSPATH') OR die('No direct script access.');

class HTML extends Kohana_HTML {
  public static function comment($author, $message, $timestamp = FALSE)
    {
        $timestamp = ($timestamp)? (int)$timestamp : time();
        $date = date("d.m.Y");
        $new_text  = '<strong>'. self::chars($author) .'</strong> <i>'. $date .'</i>';
        $new_text .= '<br /><br />'. self::chars($message);
        return $new_text;
    }
}
