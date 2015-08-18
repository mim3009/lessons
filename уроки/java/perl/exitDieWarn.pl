#!/usr/bin/perl
use strict;
use warnings;

my $str = <<'END_MENU';
>0 warning
=0 exit
<0 die
END_MENU

print $str;
print "print num pls: ";
my $num = <STDIN>;
chomp($num);

if($num > 0){
	warn();
	warn "IT`S A WARNING";
}
if($num < 0){
	die();
}
if($num == 0){
	exit();
}

