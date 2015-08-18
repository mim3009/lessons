#!/usr/bin/perl
use strict;
use warnings;

my $filename = "numbers.txt";
my $sum = 0;

open(my $fh, "<", $filename) or die "Can`t open file '$filename' . $!";
while(my $num = <$fh>){
	$sum += $num; 
}
print "The total value is $sum\n";

close $fh;