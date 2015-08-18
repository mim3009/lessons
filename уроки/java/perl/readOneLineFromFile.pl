#!/usr/bin/perl
use strict;
use warnings;

my $filename = "input.txt";
if(open(my $data, "<", $filename)){
	my $line = <$data>;
	print $line;
}else{
	warn "Coul`d not open file '$filename' . $!";
}