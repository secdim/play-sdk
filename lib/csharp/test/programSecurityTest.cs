using System;
using NUnit.Framework;

namespace program.Tests
{
    [TestFixture, Category("security")]
    public class programSecurityTest
    {
        [Test]
        public void amount_equal_or_bigger_IntMax_throw_exception()
        {
            Assert.Throws<OverflowException>(() =>
                    Program.approval(Int32.MaxValue));
        }
        [Test]
        public void amount_equal_or_bigger_IntMax_after_surcharge_throw_exception()
        {
            Assert.Throws<OverflowException>(() =>
                    Program.approval(Int32.MaxValue - 10));
        }
        [Test]
        public void amount_equal_or_less_IntMinValue_throw_exception()
        {
            Assert.Throws<ArgumentOutOfRangeException>(() =>
                    Program.approval(Int32.MinValue));
        }
        [Test]
        public void amount_zero_throw_exception()
        {

            Assert.Throws<ArgumentOutOfRangeException>(() =>
                    Program.approval(0));
        }
        [Test]
        public void amount_negative_throw_exception()
        {
            Assert.Throws<ArgumentOutOfRangeException>(() =>
                    Program.approval(-11));
        }
        [Test]
        public void amount_hex_IntMaxValue_throw_exception()
        {
            Assert.Throws<OverflowException>(() =>
                    Program.approval(0x7FFFFFFF));
        }
        [Test]
        public void amount_hex_IntMinValue_throw_exception()
        {

            Assert.Throws<ArgumentOutOfRangeException>(() =>
                    Program.approval(-0x80000000));
        }
    }
}
