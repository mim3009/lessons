use strict;
use warnings;

my $s = "The black cat jumped from the green tree";
my $z;

print index $s, "ac";
print "\n";

my $f = lc $s;
my $p = uc $s;
print "$f\n", "$p\n";
print length $s , "\n";

print index $s, "e", 3;
print "\n";

print rindex $s, "e";
print "\n";

$z = substr $s, 4, 5;
print "$z\n";

$z = substr $s, 4, -11;
print "$z\n";

$z = substr $s, -4, 2;
print "$z\n";

$z = substr $s, 14, 11, "climbed";
print "$z\n";
print "$s\n";

print "His \"real\" name is Foo\n";

my $name = "Foo";
print qq(his "real" name is $name\n);
print qq(out out out\n);
print qq(very simple to out somth...\n);

print '$f\n', "\n";

print q(print any it will out same that be $f $s), "\n";