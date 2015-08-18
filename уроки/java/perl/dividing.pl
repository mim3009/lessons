#!usr/bin/perl
use strict;
use warnings;
use v5.14;

say "print the first value pls: ";
my $a = <STDIN>;
say "print the second value pls: ";
my $b = <STDIN>;
chomp($a);
chomp($b);

if($b == 0){
	say "Can`t dividing by zero!";
}else{
	my $z = $a/$b;
	say "z is equals $z";
}
