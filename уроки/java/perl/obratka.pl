use strict;
use warnings;
use v5.14;

my $s = "roma";
my $res = "";

while($s){
	$res .= chop($s);
}

say $res;