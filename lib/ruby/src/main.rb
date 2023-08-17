# NOTE: You can import from existing libraries
# but no new libraries can be installed.

require 'sinatra'
require 'numo/narray'


def is_optimal(days)
  # 248 * 86400 * 1000
  threshold = Numo::Int32[2142720000]
  # days * 86400 * 1000
  res = days * Numo::Int32[8640000]
  res[0] >= threshold[0]
end

get '/' do
  days = params[:days]&.to_i

  if days.nil?
    '[!] Connected to Boeing 787! Enter how many days this Boeing has been operational (1 to 248): /?days=1'
  else
    result = is_optimal(days)
    if result
      '[i] Reboot is required'
    else
      remaining = 248 - days
      "[i] System is optimal. Reboot is required in #{remaining} days"
    end
  end
end
