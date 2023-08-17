require 'test/unit'
require 'rack/test'
require_relative './main'

class Usability < Test::Unit::TestCase
  include Rack::Test::Methods

  def app
    Sinatra::Application
  end

  def test_100_days_is_system_optimal
    get '/', days: '100'
    assert_equal 200, last_response.status
    assert_includes last_response.body, '[i] System is optimal'
  end

  def test_248_days_requires_reboot
    get '/', days: '248'
    assert_equal 200, last_response.status
    assert_includes last_response.body, '[i] Reboot is required'
  end

end
