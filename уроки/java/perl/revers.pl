#!/usr/bin/perl
use strict;
use warnings;
use v5.14;

say "¬ведите число:";
my $s = <STDIN>;
chomp($s);

my $res;
rev($s);

sub rev{
	my $num = $_[0];
	while($num){
		$res = $res . chop($num);
	}
}

say $res;