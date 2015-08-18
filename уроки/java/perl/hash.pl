use strict;
use warnings;

my %s = (
	apple => "red",
	banana => "yellow",
	grape => "purple",
);

print $s{banana}, "\n";

print scalar keys %s, "\n";

my @fruits = keys %s;
for my $fruit(@fruits){
	print "The colour of '$fruit' is $s{$fruit}\n"
}