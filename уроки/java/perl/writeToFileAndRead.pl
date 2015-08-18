#!/usr/bin/perl
use strict;
use warnings;

my $filename = "input.txt";
open(my $fh, ">", $filename) or die "Can`t open file '$filename' . $!";

my $title = "Report by: MIMKA";
print $fh "$title\n";
print $fh "-" x length $title, "\n";
close $fh;

open(my $data, "<", $filename) or die "Can`t open file '$filename' . $!";
while(my $str = <$data>){
	print $str;
}
close $data;