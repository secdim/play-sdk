using System;
using NUnit.Framework;

namespace program.Tests
{
    [TestFixture, Category("usability")]
    public class programUsabilityTest
    {
        [Test]
        public void amount_990_needs_approval()
        {
            bool result = Program.approval(990);  // 1000 after surchage
            Assert.IsTrue(result);
        }
        [Test]
        public void amount_500_does_not_need_approval()
        {

            bool result = Program.approval(500);
            Assert.IsFalse(result);
        }
    }
}
