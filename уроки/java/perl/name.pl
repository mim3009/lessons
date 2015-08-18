use strict;
use warnings;
use v5.14;

say "Print your name: ";
my $s = <STDIN>;
chomp($s);

if ($s eq ""){
	die ("enter some!!! $!");
}
else{
	say $s;
}