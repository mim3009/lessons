use strict;
use warnings;
use v5.10;

print "print the first number: \n";
my $width = <STDIN>;
chomp($width);

print "print the second number: \n";
my $length = <STDIN>;
chomp($length);

if($width < 0){
	say "Width is less than 0. ($width)";
	$width = 0;
}

if($length < 0){
	say "Length is less than 0. ($length)";
	$length = 0;
}

say $width * $length;