#!/usr/bin/perl
use strict;
use warnings;
use v5.10;

print "str1: ";
my $str1 = <STDIN>;
chomp($str1);

print "str2: ";
my $str2 = <STDIN>;
chomp($str2);

my $str = $str1 . $str2;
say "<$str>";