#!/usr/bin/perl
use strict;
use warnings;
use v5.10;

my $N = 200;
my $hidden = int(rand($N));

print "Please guess: ";
my $guess = <STDIN>;
chomp($guess);

if($guess < $hidden){
	say "Guess ($guess) is too small";
}

if($guess > $hidden){
	say "Guess ($guess) is too big";
}

if($guess == $hidden){
	say "Equals";
}