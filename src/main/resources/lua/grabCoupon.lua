--验证是否重复领取
local grabCoupon ="grabCoupon"..":"..KEYS[1]..":"..ARGV[1]
if redis.call('exists',grabCoupon) == 0 then
    local key = "coupon:"..KEYS[1]
    local store =tonumber(redis.call('get',key))
    --验证库存
    if  store == nil then
        return 3
    elseif store > 0 then
        --减库存
        redis.call('decr', key)
        --记录领取
        redis.call('set',grabCoupon,1)
        return 0;
    else
        return 1;
    end
else
    return 2 ;
end


