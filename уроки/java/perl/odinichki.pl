use strict;
use warnings;
use v5.14;

say "Enter a number: ";
my $num = <STDIN>;
chomp($num);
my $cnt = 0;

while($num>0){
	$cnt += $num%2;
	$num /= 2;
}
say $cnt;