use strict;
use warnings;

my $x = "Hello";
my $y = "World";

my $z = $x . " " . $y;
print "$z\n";

my $w = "Take " . (2+3);
print "$w\n";

$z .= "! ";
print "$z\n";

my $q = $z x 3;
print "$q\n";