// lib: , url: package:roselink_bluetooth/commander/receiver/zt_receiver.dart

// class id: 1050403, size: 0x8
class :: {
}

// class id: 444, size: 0x14, field offset: 0xc
class ZTReceiver extends RReceiver {

  _ checkModule(/* No info */) {
    // ** addr: 0xedbd40, size: 0x5c
    // 0xedbd40: EnterFrame
    //     0xedbd40: stp             fp, lr, [SP, #-0x10]!
    //     0xedbd44: mov             fp, SP
    // 0xedbd48: CheckStackOverflow
    //     0xedbd48: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xedbd4c: cmp             SP, x16
    //     0xedbd50: b.ls            #0xedbd94
    // 0xedbd54: r0 = LoadStaticField(0x804)
    //     0xedbd54: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xedbd58: ldr             x0, [x0, #0x1008]
    // 0xedbd5c: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xedbd60: cmp             w0, w16
    // 0xedbd64: b.ne            #0xedbd70
    // 0xedbd68: r2 = rsbt
    //     0xedbd68: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xedbd6c: r0 = InitLateFinalStaticField()
    //     0xedbd6c: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xedbd70: LoadField: r1 = r0->field_1f
    //     0xedbd70: ldur            w1, [x0, #0x1f]
    // 0xedbd74: DecompressPointer r1
    //     0xedbd74: add             x1, x1, HEAP, lsl #32
    // 0xedbd78: r2 = "模块检查 zt协议暂不支持模块消息检查功能"
    //     0xedbd78: add             x2, PP, #0x12, lsl #12  ; [pp+0x123e0] "模块检查 zt协议暂不支持模块消息检查功能"
    //     0xedbd7c: ldr             x2, [x2, #0x3e0]
    // 0xedbd80: r0 = i()
    //     0xedbd80: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xedbd84: r0 = false
    //     0xedbd84: add             x0, NULL, #0x30  ; false
    // 0xedbd88: LeaveFrame
    //     0xedbd88: mov             SP, fp
    //     0xedbd8c: ldp             fp, lr, [SP], #0x10
    // 0xedbd90: ret
    //     0xedbd90: ret             
    // 0xedbd94: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xedbd94: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xedbd98: b               #0xedbd54
  }
  _ process(/* No info */) {
    // ** addr: 0xf0dcc0, size: 0x77c
    // 0xf0dcc0: EnterFrame
    //     0xf0dcc0: stp             fp, lr, [SP, #-0x10]!
    //     0xf0dcc4: mov             fp, SP
    // 0xf0dcc8: AllocStack(0x28)
    //     0xf0dcc8: sub             SP, SP, #0x28
    // 0xf0dccc: r0 = false
    //     0xf0dccc: add             x0, NULL, #0x30  ; false
    // 0xf0dcd0: mov             x4, x1
    // 0xf0dcd4: mov             x3, x2
    // 0xf0dcd8: stur            x1, [fp, #-8]
    // 0xf0dcdc: stur            x2, [fp, #-0x10]
    // 0xf0dce0: CheckStackOverflow
    //     0xf0dce0: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0dce4: cmp             SP, x16
    //     0xf0dce8: b.ls            #0xf0e434
    // 0xf0dcec: StoreField: r4->field_f = r0
    //     0xf0dcec: stur            w0, [x4, #0xf]
    // 0xf0dcf0: r16 = 28
    //     0xf0dcf0: movz            x16, #0x1c
    // 0xf0dcf4: str             x16, [SP]
    // 0xf0dcf8: mov             x1, x3
    // 0xf0dcfc: r2 = 10
    //     0xf0dcfc: movz            x2, #0xa
    // 0xf0dd00: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0dd00: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0dd04: r0 = substring()
    //     0xf0dd04: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0dd08: r1 = LoadClassIdInstr(r0)
    //     0xf0dd08: ldur            x1, [x0, #-1]
    //     0xf0dd0c: ubfx            x1, x1, #0xc, #0x14
    // 0xf0dd10: str             x0, [SP]
    // 0xf0dd14: mov             x0, x1
    // 0xf0dd18: r0 = GDT[cid_x0 + -0x1000]()
    //     0xf0dd18: sub             lr, x0, #1, lsl #12
    //     0xf0dd1c: ldr             lr, [x21, lr, lsl #3]
    //     0xf0dd20: blr             lr
    // 0xf0dd24: stur            x0, [fp, #-0x18]
    // 0xf0dd28: r16 = "0101"
    //     0xf0dd28: add             x16, PP, #0x12, lsl #12  ; [pp+0x123e8] "0101"
    //     0xf0dd2c: ldr             x16, [x16, #0x3e8]
    // 0xf0dd30: stp             x0, x16, [SP]
    // 0xf0dd34: r0 = ==()
    //     0xf0dd34: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0dd38: tbnz            w0, #4, #0xf0dd50
    // 0xf0dd3c: ldur            x1, [fp, #-8]
    // 0xf0dd40: ldur            x2, [fp, #-0x10]
    // 0xf0dd44: r0 = _handleBatteryData()
    //     0xf0dd44: bl              #0xf0ff68  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleBatteryData
    // 0xf0dd48: ldur            x1, [fp, #-8]
    // 0xf0dd4c: b               #0xf0e40c
    // 0xf0dd50: r16 = "0103"
    //     0xf0dd50: add             x16, PP, #0x12, lsl #12  ; [pp+0x123f0] "0103"
    //     0xf0dd54: ldr             x16, [x16, #0x3f0]
    // 0xf0dd58: ldur            lr, [fp, #-0x18]
    // 0xf0dd5c: stp             lr, x16, [SP]
    // 0xf0dd60: r0 = ==()
    //     0xf0dd60: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0dd64: tbnz            w0, #4, #0xf0dd7c
    // 0xf0dd68: ldur            x1, [fp, #-8]
    // 0xf0dd6c: ldur            x2, [fp, #-0x10]
    // 0xf0dd70: r0 = _handleHeadfreeBatteryData()
    //     0xf0dd70: bl              #0xf0fe14  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleHeadfreeBatteryData
    // 0xf0dd74: ldur            x1, [fp, #-8]
    // 0xf0dd78: b               #0xf0e40c
    // 0xf0dd7c: r16 = "0d01"
    //     0xf0dd7c: add             x16, PP, #0x12, lsl #12  ; [pp+0x123f8] "0d01"
    //     0xf0dd80: ldr             x16, [x16, #0x3f8]
    // 0xf0dd84: ldur            lr, [fp, #-0x18]
    // 0xf0dd88: stp             lr, x16, [SP]
    // 0xf0dd8c: r0 = ==()
    //     0xf0dd8c: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0dd90: tbnz            w0, #4, #0xf0ddd0
    // 0xf0dd94: ldur            x1, [fp, #-0x10]
    // 0xf0dd98: LoadField: r0 = r1->field_7
    //     0xf0dd98: ldur            w0, [x1, #7]
    // 0xf0dd9c: r2 = LoadInt32Instr(r0)
    //     0xf0dd9c: sbfx            x2, x0, #1, #0x1f
    // 0xf0dda0: cmp             x2, #0x19
    // 0xf0dda4: b.le            #0xf0ddc8
    // 0xf0dda8: r16 = 52
    //     0xf0dda8: movz            x16, #0x34
    // 0xf0ddac: str             x16, [SP]
    // 0xf0ddb0: r2 = 19
    //     0xf0ddb0: movz            x2, #0x13
    // 0xf0ddb4: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0ddb4: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0ddb8: r0 = substring()
    //     0xf0ddb8: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0ddbc: ldur            x1, [fp, #-8]
    // 0xf0ddc0: mov             x2, x0
    // 0xf0ddc4: r0 = _handleFirmwareVersion()
    //     0xf0ddc4: bl              #0xf0fbec  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleFirmwareVersion
    // 0xf0ddc8: ldur            x1, [fp, #-8]
    // 0xf0ddcc: b               #0xf0e40c
    // 0xf0ddd0: ldur            x1, [fp, #-0x10]
    // 0xf0ddd4: r16 = "0201"
    //     0xf0ddd4: add             x16, PP, #0x12, lsl #12  ; [pp+0x12400] "0201"
    //     0xf0ddd8: ldr             x16, [x16, #0x400]
    // 0xf0dddc: ldur            lr, [fp, #-0x18]
    // 0xf0dde0: stp             lr, x16, [SP]
    // 0xf0dde4: r0 = ==()
    //     0xf0dde4: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0dde8: tbnz            w0, #4, #0xf0de18
    // 0xf0ddec: r16 = 40
    //     0xf0ddec: movz            x16, #0x28
    // 0xf0ddf0: str             x16, [SP]
    // 0xf0ddf4: ldur            x1, [fp, #-0x10]
    // 0xf0ddf8: r2 = 19
    //     0xf0ddf8: movz            x2, #0x13
    // 0xf0ddfc: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0ddfc: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0de00: r0 = substring()
    //     0xf0de00: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0de04: ldur            x1, [fp, #-8]
    // 0xf0de08: mov             x2, x0
    // 0xf0de0c: r0 = _handleEQData()
    //     0xf0de0c: bl              #0xf0fae8  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleEQData
    // 0xf0de10: ldur            x1, [fp, #-8]
    // 0xf0de14: b               #0xf0e40c
    // 0xf0de18: r16 = "0202"
    //     0xf0de18: add             x16, PP, #0x12, lsl #12  ; [pp+0x12408] "0202"
    //     0xf0de1c: ldr             x16, [x16, #0x408]
    // 0xf0de20: ldur            lr, [fp, #-0x18]
    // 0xf0de24: stp             lr, x16, [SP]
    // 0xf0de28: r0 = ==()
    //     0xf0de28: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0de2c: tbnz            w0, #4, #0xf0de6c
    // 0xf0de30: ldur            x1, [fp, #-0x10]
    // 0xf0de34: LoadField: r0 = r1->field_7
    //     0xf0de34: ldur            w0, [x1, #7]
    // 0xf0de38: r2 = LoadInt32Instr(r0)
    //     0xf0de38: sbfx            x2, x0, #1, #0x1f
    // 0xf0de3c: cmp             x2, #0x28
    // 0xf0de40: b.lt            #0xf0de64
    // 0xf0de44: r16 = 76
    //     0xf0de44: movz            x16, #0x4c
    // 0xf0de48: str             x16, [SP]
    // 0xf0de4c: r2 = 18
    //     0xf0de4c: movz            x2, #0x12
    // 0xf0de50: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0de50: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0de54: r0 = substring()
    //     0xf0de54: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0de58: ldur            x1, [fp, #-8]
    // 0xf0de5c: mov             x2, x0
    // 0xf0de60: r0 = _handleCustomEqData()
    //     0xf0de60: bl              #0xf0fa04  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleCustomEqData
    // 0xf0de64: ldur            x1, [fp, #-8]
    // 0xf0de68: b               #0xf0e40c
    // 0xf0de6c: ldur            x1, [fp, #-0x10]
    // 0xf0de70: r16 = "0203"
    //     0xf0de70: add             x16, PP, #0x12, lsl #12  ; [pp+0x12410] "0203"
    //     0xf0de74: ldr             x16, [x16, #0x410]
    // 0xf0de78: ldur            lr, [fp, #-0x18]
    // 0xf0de7c: stp             lr, x16, [SP]
    // 0xf0de80: r0 = ==()
    //     0xf0de80: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0de84: tbnz            w0, #4, #0xf0dec4
    // 0xf0de88: ldur            x1, [fp, #-0x10]
    // 0xf0de8c: LoadField: r0 = r1->field_7
    //     0xf0de8c: ldur            w0, [x1, #7]
    // 0xf0de90: r2 = LoadInt32Instr(r0)
    //     0xf0de90: sbfx            x2, x0, #1, #0x1f
    // 0xf0de94: cmp             x2, #0x16
    // 0xf0de98: b.lt            #0xf0debc
    // 0xf0de9c: r16 = 40
    //     0xf0de9c: movz            x16, #0x28
    // 0xf0dea0: str             x16, [SP]
    // 0xf0dea4: r2 = 18
    //     0xf0dea4: movz            x2, #0x12
    // 0xf0dea8: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0dea8: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0deac: r0 = substring()
    //     0xf0deac: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0deb0: ldur            x1, [fp, #-8]
    // 0xf0deb4: mov             x2, x0
    // 0xf0deb8: r0 = _handleGainLevel()
    //     0xf0deb8: bl              #0xf0f8e0  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleGainLevel
    // 0xf0debc: ldur            x1, [fp, #-8]
    // 0xf0dec0: b               #0xf0e40c
    // 0xf0dec4: ldur            x1, [fp, #-0x10]
    // 0xf0dec8: r16 = "0401"
    //     0xf0dec8: add             x16, PP, #0x12, lsl #12  ; [pp+0x12418] "0401"
    //     0xf0decc: ldr             x16, [x16, #0x418]
    // 0xf0ded0: ldur            lr, [fp, #-0x18]
    // 0xf0ded4: stp             lr, x16, [SP]
    // 0xf0ded8: r0 = ==()
    //     0xf0ded8: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0dedc: tbnz            w0, #4, #0xf0def4
    // 0xf0dee0: ldur            x1, [fp, #-8]
    // 0xf0dee4: ldur            x2, [fp, #-0x10]
    // 0xf0dee8: r0 = _handleKeyData()
    //     0xf0dee8: bl              #0xf0f61c  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleKeyData
    // 0xf0deec: ldur            x1, [fp, #-8]
    // 0xf0def0: b               #0xf0e40c
    // 0xf0def4: r16 = "0603"
    //     0xf0def4: add             x16, PP, #0x12, lsl #12  ; [pp+0x12420] "0603"
    //     0xf0def8: ldr             x16, [x16, #0x420]
    // 0xf0defc: ldur            lr, [fp, #-0x18]
    // 0xf0df00: stp             lr, x16, [SP]
    // 0xf0df04: r0 = ==()
    //     0xf0df04: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0df08: tbnz            w0, #4, #0xf0df38
    // 0xf0df0c: r16 = 40
    //     0xf0df0c: movz            x16, #0x28
    // 0xf0df10: str             x16, [SP]
    // 0xf0df14: ldur            x1, [fp, #-0x10]
    // 0xf0df18: r2 = 19
    //     0xf0df18: movz            x2, #0x13
    // 0xf0df1c: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0df1c: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0df20: r0 = substring()
    //     0xf0df20: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0df24: ldur            x1, [fp, #-8]
    // 0xf0df28: mov             x2, x0
    // 0xf0df2c: r0 = _handleGameMode()
    //     0xf0df2c: bl              #0xf0f518  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleGameMode
    // 0xf0df30: ldur            x1, [fp, #-8]
    // 0xf0df34: b               #0xf0e40c
    // 0xf0df38: r16 = "0c01"
    //     0xf0df38: add             x16, PP, #0x12, lsl #12  ; [pp+0x12428] "0c01"
    //     0xf0df3c: ldr             x16, [x16, #0x428]
    // 0xf0df40: ldur            lr, [fp, #-0x18]
    // 0xf0df44: stp             lr, x16, [SP]
    // 0xf0df48: r0 = ==()
    //     0xf0df48: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0df4c: tbnz            w0, #4, #0xf0df7c
    // 0xf0df50: r16 = 40
    //     0xf0df50: movz            x16, #0x28
    // 0xf0df54: str             x16, [SP]
    // 0xf0df58: ldur            x1, [fp, #-0x10]
    // 0xf0df5c: r2 = 19
    //     0xf0df5c: movz            x2, #0x13
    // 0xf0df60: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0df60: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0df64: r0 = substring()
    //     0xf0df64: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0df68: ldur            x1, [fp, #-8]
    // 0xf0df6c: mov             x2, x0
    // 0xf0df70: r0 = _handleInEarDetection()
    //     0xf0df70: bl              #0xf0f414  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleInEarDetection
    // 0xf0df74: ldur            x1, [fp, #-8]
    // 0xf0df78: b               #0xf0e40c
    // 0xf0df7c: r16 = "0801"
    //     0xf0df7c: add             x16, PP, #0x12, lsl #12  ; [pp+0x12430] "0801"
    //     0xf0df80: ldr             x16, [x16, #0x430]
    // 0xf0df84: ldur            lr, [fp, #-0x18]
    // 0xf0df88: stp             lr, x16, [SP]
    // 0xf0df8c: r0 = ==()
    //     0xf0df8c: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0df90: tbnz            w0, #4, #0xf0dfc0
    // 0xf0df94: r16 = 40
    //     0xf0df94: movz            x16, #0x28
    // 0xf0df98: str             x16, [SP]
    // 0xf0df9c: ldur            x1, [fp, #-0x10]
    // 0xf0dfa0: r2 = 19
    //     0xf0dfa0: movz            x2, #0x13
    // 0xf0dfa4: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0dfa4: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0dfa8: r0 = substring()
    //     0xf0dfa8: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0dfac: ldur            x1, [fp, #-8]
    // 0xf0dfb0: mov             x2, x0
    // 0xf0dfb4: r0 = _handleConnectionMode()
    //     0xf0dfb4: bl              #0xf0f314  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleConnectionMode
    // 0xf0dfb8: ldur            x1, [fp, #-8]
    // 0xf0dfbc: b               #0xf0e40c
    // 0xf0dfc0: r16 = "0602"
    //     0xf0dfc0: add             x16, PP, #0x12, lsl #12  ; [pp+0x12438] "0602"
    //     0xf0dfc4: ldr             x16, [x16, #0x438]
    // 0xf0dfc8: ldur            lr, [fp, #-0x18]
    // 0xf0dfcc: stp             lr, x16, [SP]
    // 0xf0dfd0: r0 = ==()
    //     0xf0dfd0: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0dfd4: tbnz            w0, #4, #0xf0e018
    // 0xf0dfd8: ldur            x1, [fp, #-0x10]
    // 0xf0dfdc: r2 = 18
    //     0xf0dfdc: movz            x2, #0x12
    // 0xf0dfe0: r4 = const [0, 0x2, 0, 0x2, null]
    //     0xf0dfe0: ldr             x4, [PP, #0x5b0]  ; [pp+0x5b0] List(5) [0, 0x2, 0, 0x2, Null]
    // 0xf0dfe4: r0 = substring()
    //     0xf0dfe4: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0dfe8: r1 = LoadClassIdInstr(r0)
    //     0xf0dfe8: ldur            x1, [x0, #-1]
    //     0xf0dfec: ubfx            x1, x1, #0xc, #0x14
    // 0xf0dff0: str             x0, [SP]
    // 0xf0dff4: mov             x0, x1
    // 0xf0dff8: r0 = GDT[cid_x0 + -0x1000]()
    //     0xf0dff8: sub             lr, x0, #1, lsl #12
    //     0xf0dffc: ldr             lr, [x21, lr, lsl #3]
    //     0xf0e000: blr             lr
    // 0xf0e004: ldur            x1, [fp, #-8]
    // 0xf0e008: mov             x2, x0
    // 0xf0e00c: r0 = _handleANCData()
    //     0xf0e00c: bl              #0xf0f138  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleANCData
    // 0xf0e010: ldur            x1, [fp, #-8]
    // 0xf0e014: b               #0xf0e40c
    // 0xf0e018: r16 = "0607"
    //     0xf0e018: add             x16, PP, #0x12, lsl #12  ; [pp+0x12440] "0607"
    //     0xf0e01c: ldr             x16, [x16, #0x440]
    // 0xf0e020: ldur            lr, [fp, #-0x18]
    // 0xf0e024: stp             lr, x16, [SP]
    // 0xf0e028: r0 = ==()
    //     0xf0e028: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0e02c: tbnz            w0, #4, #0xf0e144
    // 0xf0e030: ldur            x0, [fp, #-8]
    // 0xf0e034: LoadField: r1 = r0->field_b
    //     0xf0e034: ldur            w1, [x0, #0xb]
    // 0xf0e038: DecompressPointer r1
    //     0xf0e038: add             x1, x1, HEAP, lsl #32
    // 0xf0e03c: tbnz            w1, #4, #0xf0e118
    // 0xf0e040: r16 = 36
    //     0xf0e040: movz            x16, #0x24
    // 0xf0e044: str             x16, [SP]
    // 0xf0e048: ldur            x1, [fp, #-0x10]
    // 0xf0e04c: r2 = 14
    //     0xf0e04c: movz            x2, #0xe
    // 0xf0e050: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e050: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e054: r0 = substring()
    //     0xf0e054: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e058: r1 = LoadClassIdInstr(r0)
    //     0xf0e058: ldur            x1, [x0, #-1]
    //     0xf0e05c: ubfx            x1, x1, #0xc, #0x14
    // 0xf0e060: r16 = "0c00"
    //     0xf0e060: add             x16, PP, #0x12, lsl #12  ; [pp+0x12448] "0c00"
    //     0xf0e064: ldr             x16, [x16, #0x448]
    // 0xf0e068: stp             x16, x0, [SP]
    // 0xf0e06c: mov             x0, x1
    // 0xf0e070: mov             lr, x0
    // 0xf0e074: ldr             lr, [x21, lr, lsl #3]
    // 0xf0e078: blr             lr
    // 0xf0e07c: tbnz            w0, #4, #0xf0e0cc
    // 0xf0e080: r16 = 40
    //     0xf0e080: movz            x16, #0x28
    // 0xf0e084: str             x16, [SP]
    // 0xf0e088: ldur            x1, [fp, #-0x10]
    // 0xf0e08c: r2 = 18
    //     0xf0e08c: movz            x2, #0x12
    // 0xf0e090: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e090: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e094: r0 = substring()
    //     0xf0e094: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e098: ldur            x1, [fp, #-8]
    // 0xf0e09c: mov             x2, x0
    // 0xf0e0a0: r0 = _handleANCLevel()
    //     0xf0e0a0: bl              #0xf0f040  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleANCLevel
    // 0xf0e0a4: r16 = 44
    //     0xf0e0a4: movz            x16, #0x2c
    // 0xf0e0a8: str             x16, [SP]
    // 0xf0e0ac: ldur            x1, [fp, #-0x10]
    // 0xf0e0b0: r2 = 20
    //     0xf0e0b0: movz            x2, #0x14
    // 0xf0e0b4: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e0b4: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e0b8: r0 = substring()
    //     0xf0e0b8: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e0bc: ldur            x1, [fp, #-8]
    // 0xf0e0c0: mov             x2, x0
    // 0xf0e0c4: r0 = _handleTransparencyLevel()
    //     0xf0e0c4: bl              #0xf0ef48  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleTransparencyLevel
    // 0xf0e0c8: b               #0xf0e13c
    // 0xf0e0cc: r16 = 40
    //     0xf0e0cc: movz            x16, #0x28
    // 0xf0e0d0: str             x16, [SP]
    // 0xf0e0d4: ldur            x1, [fp, #-0x10]
    // 0xf0e0d8: r2 = 18
    //     0xf0e0d8: movz            x2, #0x12
    // 0xf0e0dc: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e0dc: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e0e0: r0 = substring()
    //     0xf0e0e0: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e0e4: ldur            x1, [fp, #-8]
    // 0xf0e0e8: mov             x2, x0
    // 0xf0e0ec: r0 = _handleTransparencyLevel()
    //     0xf0e0ec: bl              #0xf0ef48  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleTransparencyLevel
    // 0xf0e0f0: r16 = 44
    //     0xf0e0f0: movz            x16, #0x2c
    // 0xf0e0f4: str             x16, [SP]
    // 0xf0e0f8: ldur            x1, [fp, #-0x10]
    // 0xf0e0fc: r2 = 20
    //     0xf0e0fc: movz            x2, #0x14
    // 0xf0e100: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e100: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e104: r0 = substring()
    //     0xf0e104: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e108: ldur            x1, [fp, #-8]
    // 0xf0e10c: mov             x2, x0
    // 0xf0e110: r0 = _handleANCLevel()
    //     0xf0e110: bl              #0xf0f040  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleANCLevel
    // 0xf0e114: b               #0xf0e13c
    // 0xf0e118: r16 = 40
    //     0xf0e118: movz            x16, #0x28
    // 0xf0e11c: str             x16, [SP]
    // 0xf0e120: ldur            x1, [fp, #-0x10]
    // 0xf0e124: r2 = 18
    //     0xf0e124: movz            x2, #0x12
    // 0xf0e128: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e128: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e12c: r0 = substring()
    //     0xf0e12c: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e130: ldur            x1, [fp, #-8]
    // 0xf0e134: mov             x2, x0
    // 0xf0e138: r0 = _handleANCLevel()
    //     0xf0e138: bl              #0xf0f040  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleANCLevel
    // 0xf0e13c: ldur            x1, [fp, #-8]
    // 0xf0e140: b               #0xf0e40c
    // 0xf0e144: r16 = "0604"
    //     0xf0e144: add             x16, PP, #0x12, lsl #12  ; [pp+0x12450] "0604"
    //     0xf0e148: ldr             x16, [x16, #0x450]
    // 0xf0e14c: ldur            lr, [fp, #-0x18]
    // 0xf0e150: stp             lr, x16, [SP]
    // 0xf0e154: r0 = ==()
    //     0xf0e154: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0e158: tbnz            w0, #4, #0xf0e188
    // 0xf0e15c: r16 = 40
    //     0xf0e15c: movz            x16, #0x28
    // 0xf0e160: str             x16, [SP]
    // 0xf0e164: ldur            x1, [fp, #-0x10]
    // 0xf0e168: r2 = 18
    //     0xf0e168: movz            x2, #0x12
    // 0xf0e16c: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e16c: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e170: r0 = substring()
    //     0xf0e170: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e174: ldur            x1, [fp, #-8]
    // 0xf0e178: mov             x2, x0
    // 0xf0e17c: r0 = _handleTransparencyLevel()
    //     0xf0e17c: bl              #0xf0ef48  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleTransparencyLevel
    // 0xf0e180: ldur            x1, [fp, #-8]
    // 0xf0e184: b               #0xf0e40c
    // 0xf0e188: r16 = "0e03"
    //     0xf0e188: add             x16, PP, #0x12, lsl #12  ; [pp+0x12458] "0e03"
    //     0xf0e18c: ldr             x16, [x16, #0x458]
    // 0xf0e190: ldur            lr, [fp, #-0x18]
    // 0xf0e194: stp             lr, x16, [SP]
    // 0xf0e198: r0 = ==()
    //     0xf0e198: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0e19c: tbnz            w0, #4, #0xf0e1e4
    // 0xf0e1a0: ldur            x0, [fp, #-8]
    // 0xf0e1a4: LoadField: r1 = r0->field_b
    //     0xf0e1a4: ldur            w1, [x0, #0xb]
    // 0xf0e1a8: DecompressPointer r1
    //     0xf0e1a8: add             x1, x1, HEAP, lsl #32
    // 0xf0e1ac: tbnz            w1, #4, #0xf0e1b8
    // 0xf0e1b0: mov             x1, x0
    // 0xf0e1b4: b               #0xf0e40c
    // 0xf0e1b8: r16 = 40
    //     0xf0e1b8: movz            x16, #0x28
    // 0xf0e1bc: str             x16, [SP]
    // 0xf0e1c0: ldur            x1, [fp, #-0x10]
    // 0xf0e1c4: r2 = 19
    //     0xf0e1c4: movz            x2, #0x13
    // 0xf0e1c8: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e1c8: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e1cc: r0 = substring()
    //     0xf0e1cc: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e1d0: ldur            x1, [fp, #-8]
    // 0xf0e1d4: mov             x2, x0
    // 0xf0e1d8: r0 = _handlePromptToneLevel()
    //     0xf0e1d8: bl              #0xf0ee40  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handlePromptToneLevel
    // 0xf0e1dc: ldur            x1, [fp, #-8]
    // 0xf0e1e0: b               #0xf0e40c
    // 0xf0e1e4: r16 = "0e06"
    //     0xf0e1e4: add             x16, PP, #0x12, lsl #12  ; [pp+0x12460] "0e06"
    //     0xf0e1e8: ldr             x16, [x16, #0x460]
    // 0xf0e1ec: ldur            lr, [fp, #-0x18]
    // 0xf0e1f0: stp             lr, x16, [SP]
    // 0xf0e1f4: r0 = ==()
    //     0xf0e1f4: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0e1f8: tbnz            w0, #4, #0xf0e290
    // 0xf0e1fc: r16 = 36
    //     0xf0e1fc: movz            x16, #0x24
    // 0xf0e200: str             x16, [SP]
    // 0xf0e204: ldur            x1, [fp, #-0x10]
    // 0xf0e208: r2 = 14
    //     0xf0e208: movz            x2, #0xe
    // 0xf0e20c: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e20c: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e210: r0 = substring()
    //     0xf0e210: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e214: r1 = LoadClassIdInstr(r0)
    //     0xf0e214: ldur            x1, [x0, #-1]
    //     0xf0e218: ubfx            x1, x1, #0xc, #0x14
    // 0xf0e21c: r16 = "0b00"
    //     0xf0e21c: add             x16, PP, #0x12, lsl #12  ; [pp+0x12468] "0b00"
    //     0xf0e220: ldr             x16, [x16, #0x468]
    // 0xf0e224: stp             x16, x0, [SP]
    // 0xf0e228: mov             x0, x1
    // 0xf0e22c: mov             lr, x0
    // 0xf0e230: ldr             lr, [x21, lr, lsl #3]
    // 0xf0e234: blr             lr
    // 0xf0e238: tbnz            w0, #4, #0xf0e264
    // 0xf0e23c: r16 = 40
    //     0xf0e23c: movz            x16, #0x28
    // 0xf0e240: str             x16, [SP]
    // 0xf0e244: ldur            x1, [fp, #-0x10]
    // 0xf0e248: r2 = 19
    //     0xf0e248: movz            x2, #0x13
    // 0xf0e24c: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e24c: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e250: r0 = substring()
    //     0xf0e250: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e254: ldur            x1, [fp, #-8]
    // 0xf0e258: mov             x2, x0
    // 0xf0e25c: r0 = _handlePromptToneLevelHeadfree()
    //     0xf0e25c: bl              #0xf0ed3c  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handlePromptToneLevelHeadfree
    // 0xf0e260: b               #0xf0e288
    // 0xf0e264: r16 = 40
    //     0xf0e264: movz            x16, #0x28
    // 0xf0e268: str             x16, [SP]
    // 0xf0e26c: ldur            x1, [fp, #-0x10]
    // 0xf0e270: r2 = 18
    //     0xf0e270: movz            x2, #0x12
    // 0xf0e274: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e274: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e278: r0 = substring()
    //     0xf0e278: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e27c: ldur            x1, [fp, #-8]
    // 0xf0e280: mov             x2, x0
    // 0xf0e284: r0 = _handlePromptToneLevelHeadfree()
    //     0xf0e284: bl              #0xf0ed3c  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handlePromptToneLevelHeadfree
    // 0xf0e288: ldur            x1, [fp, #-8]
    // 0xf0e28c: b               #0xf0e40c
    // 0xf0e290: r16 = "0a01"
    //     0xf0e290: add             x16, PP, #0x12, lsl #12  ; [pp+0x12470] "0a01"
    //     0xf0e294: ldr             x16, [x16, #0x470]
    // 0xf0e298: ldur            lr, [fp, #-0x18]
    // 0xf0e29c: stp             lr, x16, [SP]
    // 0xf0e2a0: r0 = ==()
    //     0xf0e2a0: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0e2a4: tbnz            w0, #4, #0xf0e2d4
    // 0xf0e2a8: r16 = 40
    //     0xf0e2a8: movz            x16, #0x28
    // 0xf0e2ac: str             x16, [SP]
    // 0xf0e2b0: ldur            x1, [fp, #-0x10]
    // 0xf0e2b4: r2 = 19
    //     0xf0e2b4: movz            x2, #0x13
    // 0xf0e2b8: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e2b8: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e2bc: r0 = substring()
    //     0xf0e2bc: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e2c0: ldur            x1, [fp, #-8]
    // 0xf0e2c4: mov             x2, x0
    // 0xf0e2c8: r0 = _handleTouchControl()
    //     0xf0e2c8: bl              #0xf0ec38  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleTouchControl
    // 0xf0e2cc: ldur            x1, [fp, #-8]
    // 0xf0e2d0: b               #0xf0e40c
    // 0xf0e2d4: r16 = "0e02"
    //     0xf0e2d4: add             x16, PP, #0x12, lsl #12  ; [pp+0x12478] "0e02"
    //     0xf0e2d8: ldr             x16, [x16, #0x478]
    // 0xf0e2dc: ldur            lr, [fp, #-0x18]
    // 0xf0e2e0: stp             lr, x16, [SP]
    // 0xf0e2e4: r0 = ==()
    //     0xf0e2e4: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0e2e8: tbnz            w0, #4, #0xf0e318
    // 0xf0e2ec: r16 = 44
    //     0xf0e2ec: movz            x16, #0x2c
    // 0xf0e2f0: str             x16, [SP]
    // 0xf0e2f4: ldur            x1, [fp, #-0x10]
    // 0xf0e2f8: r2 = 18
    //     0xf0e2f8: movz            x2, #0x12
    // 0xf0e2fc: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e2fc: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e300: r0 = substring()
    //     0xf0e300: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e304: ldur            x1, [fp, #-8]
    // 0xf0e308: mov             x2, x0
    // 0xf0e30c: r0 = _handleEarFind()
    //     0xf0e30c: bl              #0xf0eb68  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleEarFind
    // 0xf0e310: ldur            x1, [fp, #-8]
    // 0xf0e314: b               #0xf0e40c
    // 0xf0e318: r16 = "0605"
    //     0xf0e318: add             x16, PP, #0x12, lsl #12  ; [pp+0x12480] "0605"
    //     0xf0e31c: ldr             x16, [x16, #0x480]
    // 0xf0e320: ldur            lr, [fp, #-0x18]
    // 0xf0e324: stp             lr, x16, [SP]
    // 0xf0e328: r0 = ==()
    //     0xf0e328: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0e32c: tbnz            w0, #4, #0xf0e35c
    // 0xf0e330: r16 = 52
    //     0xf0e330: movz            x16, #0x34
    // 0xf0e334: str             x16, [SP]
    // 0xf0e338: ldur            x1, [fp, #-0x10]
    // 0xf0e33c: r2 = 19
    //     0xf0e33c: movz            x2, #0x13
    // 0xf0e340: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e340: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e344: r0 = substring()
    //     0xf0e344: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e348: ldur            x1, [fp, #-8]
    // 0xf0e34c: mov             x2, x0
    // 0xf0e350: r0 = _handleAncList()
    //     0xf0e350: bl              #0xf0e844  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleAncList
    // 0xf0e354: ldur            x1, [fp, #-8]
    // 0xf0e358: b               #0xf0e40c
    // 0xf0e35c: r16 = "0802"
    //     0xf0e35c: add             x16, PP, #0x12, lsl #12  ; [pp+0x12488] "0802"
    //     0xf0e360: ldr             x16, [x16, #0x488]
    // 0xf0e364: ldur            lr, [fp, #-0x18]
    // 0xf0e368: stp             lr, x16, [SP]
    // 0xf0e36c: r0 = ==()
    //     0xf0e36c: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0e370: tbnz            w0, #4, #0xf0e3a0
    // 0xf0e374: r16 = 40
    //     0xf0e374: movz            x16, #0x28
    // 0xf0e378: str             x16, [SP]
    // 0xf0e37c: ldur            x1, [fp, #-0x10]
    // 0xf0e380: r2 = 19
    //     0xf0e380: movz            x2, #0x13
    // 0xf0e384: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e384: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e388: r0 = substring()
    //     0xf0e388: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e38c: ldur            x1, [fp, #-8]
    // 0xf0e390: mov             x2, x0
    // 0xf0e394: r0 = _handleMultiDevice()
    //     0xf0e394: bl              #0xf0e73c  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleMultiDevice
    // 0xf0e398: ldur            x1, [fp, #-8]
    // 0xf0e39c: b               #0xf0e40c
    // 0xf0e3a0: r16 = "0803"
    //     0xf0e3a0: add             x16, PP, #0x12, lsl #12  ; [pp+0x12490] "0803"
    //     0xf0e3a4: ldr             x16, [x16, #0x490]
    // 0xf0e3a8: ldur            lr, [fp, #-0x18]
    // 0xf0e3ac: stp             lr, x16, [SP]
    // 0xf0e3b0: r0 = ==()
    //     0xf0e3b0: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0e3b4: tbnz            w0, #4, #0xf0e3cc
    // 0xf0e3b8: ldur            x1, [fp, #-8]
    // 0xf0e3bc: ldur            x2, [fp, #-0x10]
    // 0xf0e3c0: r0 = _handleMultiDeviceNameList()
    //     0xf0e3c0: bl              #0xf0e544  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleMultiDeviceNameList
    // 0xf0e3c4: ldur            x1, [fp, #-8]
    // 0xf0e3c8: b               #0xf0e40c
    // 0xf0e3cc: r16 = "0b01"
    //     0xf0e3cc: add             x16, PP, #0x12, lsl #12  ; [pp+0x12498] "0b01"
    //     0xf0e3d0: ldr             x16, [x16, #0x498]
    // 0xf0e3d4: ldur            lr, [fp, #-0x18]
    // 0xf0e3d8: stp             lr, x16, [SP]
    // 0xf0e3dc: r0 = ==()
    //     0xf0e3dc: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xf0e3e0: tbnz            w0, #4, #0xf0e424
    // 0xf0e3e4: r16 = 40
    //     0xf0e3e4: movz            x16, #0x28
    // 0xf0e3e8: str             x16, [SP]
    // 0xf0e3ec: ldur            x1, [fp, #-0x10]
    // 0xf0e3f0: r2 = 18
    //     0xf0e3f0: movz            x2, #0x12
    // 0xf0e3f4: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e3f4: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e3f8: r0 = substring()
    //     0xf0e3f8: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e3fc: ldur            x1, [fp, #-8]
    // 0xf0e400: mov             x2, x0
    // 0xf0e404: r0 = _handleHideSearch()
    //     0xf0e404: bl              #0xf0e43c  ; [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleHideSearch
    // 0xf0e408: ldur            x1, [fp, #-8]
    // 0xf0e40c: r2 = true
    //     0xf0e40c: add             x2, NULL, #0x20  ; true
    // 0xf0e410: StoreField: r1->field_f = r2
    //     0xf0e410: stur            w2, [x1, #0xf]
    // 0xf0e414: r0 = Null
    //     0xf0e414: mov             x0, NULL
    // 0xf0e418: LeaveFrame
    //     0xf0e418: mov             SP, fp
    //     0xf0e41c: ldp             fp, lr, [SP], #0x10
    // 0xf0e420: ret
    //     0xf0e420: ret             
    // 0xf0e424: r0 = Null
    //     0xf0e424: mov             x0, NULL
    // 0xf0e428: LeaveFrame
    //     0xf0e428: mov             SP, fp
    //     0xf0e42c: ldp             fp, lr, [SP], #0x10
    // 0xf0e430: ret
    //     0xf0e430: ret             
    // 0xf0e434: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0e434: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0e438: b               #0xf0dcec
  }
  _ _handleHideSearch(/* No info */) {
    // ** addr: 0xf0e43c, size: 0x108
    // 0xf0e43c: EnterFrame
    //     0xf0e43c: stp             fp, lr, [SP, #-0x10]!
    //     0xf0e440: mov             fp, SP
    // 0xf0e444: AllocStack(0x28)
    //     0xf0e444: sub             SP, SP, #0x28
    // 0xf0e448: SetupParameters(ZTReceiver this /* r1 => r1, fp-0x8 */, dynamic _ /* r2 => r2, fp-0x10 */)
    //     0xf0e448: stur            x1, [fp, #-8]
    //     0xf0e44c: stur            x2, [fp, #-0x10]
    // 0xf0e450: CheckStackOverflow
    //     0xf0e450: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0e454: cmp             SP, x16
    //     0xf0e458: b.ls            #0xf0e530
    // 0xf0e45c: r0 = LoadStaticField(0x804)
    //     0xf0e45c: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0e460: ldr             x0, [x0, #0x1008]
    // 0xf0e464: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0e468: cmp             w0, w16
    // 0xf0e46c: b.ne            #0xf0e478
    // 0xf0e470: r2 = rsbt
    //     0xf0e470: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0e474: r0 = InitLateFinalStaticField()
    //     0xf0e474: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0e478: LoadField: r3 = r0->field_1f
    //     0xf0e478: ldur            w3, [x0, #0x1f]
    // 0xf0e47c: DecompressPointer r3
    //     0xf0e47c: add             x3, x3, HEAP, lsl #32
    // 0xf0e480: stur            x3, [fp, #-0x18]
    // 0xf0e484: r1 = Null
    //     0xf0e484: mov             x1, NULL
    // 0xf0e488: r2 = 4
    //     0xf0e488: movz            x2, #0x4
    // 0xf0e48c: r0 = AllocateArray()
    //     0xf0e48c: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0e490: r16 = "隐藏搜索获取到了 "
    //     0xf0e490: add             x16, PP, #0x12, lsl #12  ; [pp+0x124a0] "隐藏搜索获取到了 "
    //     0xf0e494: ldr             x16, [x16, #0x4a0]
    // 0xf0e498: StoreField: r0->field_f = r16
    //     0xf0e498: stur            w16, [x0, #0xf]
    // 0xf0e49c: ldur            x1, [fp, #-0x10]
    // 0xf0e4a0: StoreField: r0->field_13 = r1
    //     0xf0e4a0: stur            w1, [x0, #0x13]
    // 0xf0e4a4: str             x0, [SP]
    // 0xf0e4a8: r0 = _interpolate()
    //     0xf0e4a8: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0e4ac: ldur            x1, [fp, #-0x18]
    // 0xf0e4b0: mov             x2, x0
    // 0xf0e4b4: r0 = i()
    //     0xf0e4b4: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xf0e4b8: ldur            x0, [fp, #-8]
    // 0xf0e4bc: LoadField: r1 = r0->field_7
    //     0xf0e4bc: ldur            w1, [x0, #7]
    // 0xf0e4c0: DecompressPointer r1
    //     0xf0e4c0: add             x1, x1, HEAP, lsl #32
    // 0xf0e4c4: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0e4c8: cmp             w1, w16
    // 0xf0e4cc: b.eq            #0xf0e538
    // 0xf0e4d0: ldur            x0, [fp, #-0x10]
    // 0xf0e4d4: stur            x1, [fp, #-0x18]
    // 0xf0e4d8: r2 = LoadClassIdInstr(r0)
    //     0xf0e4d8: ldur            x2, [x0, #-1]
    //     0xf0e4dc: ubfx            x2, x2, #0xc, #0x14
    // 0xf0e4e0: r16 = "00"
    //     0xf0e4e0: ldr             x16, [PP, #0x7578]  ; [pp+0x7578] "00"
    // 0xf0e4e4: stp             x16, x0, [SP]
    // 0xf0e4e8: mov             x0, x2
    // 0xf0e4ec: mov             lr, x0
    // 0xf0e4f0: ldr             lr, [x21, lr, lsl #3]
    // 0xf0e4f4: blr             lr
    // 0xf0e4f8: ldur            x1, [fp, #-0x18]
    // 0xf0e4fc: r2 = LoadClassIdInstr(r1)
    //     0xf0e4fc: ldur            x2, [x1, #-1]
    //     0xf0e500: ubfx            x2, x2, #0xc, #0x14
    // 0xf0e504: mov             x16, x0
    // 0xf0e508: mov             x0, x2
    // 0xf0e50c: mov             x2, x16
    // 0xf0e510: r0 = GDT[cid_x0 + 0xde0f]()
    //     0xf0e510: movz            x17, #0xde0f
    //     0xf0e514: add             lr, x0, x17
    //     0xf0e518: ldr             lr, [x21, lr, lsl #3]
    //     0xf0e51c: blr             lr
    // 0xf0e520: r0 = Null
    //     0xf0e520: mov             x0, NULL
    // 0xf0e524: LeaveFrame
    //     0xf0e524: mov             SP, fp
    //     0xf0e528: ldp             fp, lr, [SP], #0x10
    // 0xf0e52c: ret
    //     0xf0e52c: ret             
    // 0xf0e530: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0e530: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0e534: b               #0xf0e45c
    // 0xf0e538: r9 = receiveHandler
    //     0xf0e538: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf0e53c: ldr             x9, [x9, #0x4a8]
    // 0xf0e540: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf0e540: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleMultiDeviceNameList(/* No info */) {
    // ** addr: 0xf0e544, size: 0x1f8
    // 0xf0e544: EnterFrame
    //     0xf0e544: stp             fp, lr, [SP, #-0x10]!
    //     0xf0e548: mov             fp, SP
    // 0xf0e54c: AllocStack(0x20)
    //     0xf0e54c: sub             SP, SP, #0x20
    // 0xf0e550: SetupParameters(ZTReceiver this /* r1 => r0, fp-0x8 */, dynamic _ /* r2 => r1, fp-0x10 */)
    //     0xf0e550: mov             x0, x1
    //     0xf0e554: stur            x1, [fp, #-8]
    //     0xf0e558: mov             x1, x2
    //     0xf0e55c: stur            x2, [fp, #-0x10]
    // 0xf0e560: CheckStackOverflow
    //     0xf0e560: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0e564: cmp             SP, x16
    //     0xf0e568: b.ls            #0xf0e728
    // 0xf0e56c: r0 = LoadStaticField(0x804)
    //     0xf0e56c: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0e570: ldr             x0, [x0, #0x1008]
    // 0xf0e574: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0e578: cmp             w0, w16
    // 0xf0e57c: b.ne            #0xf0e588
    // 0xf0e580: r2 = rsbt
    //     0xf0e580: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0e584: r0 = InitLateFinalStaticField()
    //     0xf0e584: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0e588: LoadField: r3 = r0->field_1f
    //     0xf0e588: ldur            w3, [x0, #0x1f]
    // 0xf0e58c: DecompressPointer r3
    //     0xf0e58c: add             x3, x3, HEAP, lsl #32
    // 0xf0e590: stur            x3, [fp, #-0x18]
    // 0xf0e594: r1 = Null
    //     0xf0e594: mov             x1, NULL
    // 0xf0e598: r2 = 4
    //     0xf0e598: movz            x2, #0x4
    // 0xf0e59c: r0 = AllocateArray()
    //     0xf0e59c: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0e5a0: r16 = "设备历史列表获取到了 "
    //     0xf0e5a0: add             x16, PP, #0x12, lsl #12  ; [pp+0x124b0] "设备历史列表获取到了 "
    //     0xf0e5a4: ldr             x16, [x16, #0x4b0]
    // 0xf0e5a8: StoreField: r0->field_f = r16
    //     0xf0e5a8: stur            w16, [x0, #0xf]
    // 0xf0e5ac: ldur            x1, [fp, #-0x10]
    // 0xf0e5b0: StoreField: r0->field_13 = r1
    //     0xf0e5b0: stur            w1, [x0, #0x13]
    // 0xf0e5b4: str             x0, [SP]
    // 0xf0e5b8: r0 = _interpolate()
    //     0xf0e5b8: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0e5bc: ldur            x1, [fp, #-0x18]
    // 0xf0e5c0: mov             x2, x0
    // 0xf0e5c4: r0 = i()
    //     0xf0e5c4: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xf0e5c8: r16 = 196
    //     0xf0e5c8: movz            x16, #0xc4
    // 0xf0e5cc: str             x16, [SP]
    // 0xf0e5d0: ldur            x1, [fp, #-0x10]
    // 0xf0e5d4: r2 = 34
    //     0xf0e5d4: movz            x2, #0x22
    // 0xf0e5d8: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e5d8: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e5dc: r0 = substring()
    //     0xf0e5dc: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e5e0: r16 = 68
    //     0xf0e5e0: movz            x16, #0x44
    // 0xf0e5e4: str             x16, [SP]
    // 0xf0e5e8: ldur            x1, [fp, #-0x10]
    // 0xf0e5ec: r2 = 22
    //     0xf0e5ec: movz            x2, #0x16
    // 0xf0e5f0: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e5f0: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e5f4: r0 = substring()
    //     0xf0e5f4: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e5f8: r16 = 40
    //     0xf0e5f8: movz            x16, #0x28
    // 0xf0e5fc: str             x16, [SP]
    // 0xf0e600: ldur            x1, [fp, #-0x10]
    // 0xf0e604: r2 = 18
    //     0xf0e604: movz            x2, #0x12
    // 0xf0e608: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e608: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e60c: r0 = substring()
    //     0xf0e60c: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e610: r16 = 32
    //     0xf0e610: movz            x16, #0x20
    // 0xf0e614: str             x16, [SP]
    // 0xf0e618: mov             x1, x0
    // 0xf0e61c: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf0e61c: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf0e620: ldr             x4, [x4, #0x128]
    // 0xf0e624: r0 = parse()
    //     0xf0e624: bl              #0x621868  ; [dart:core] int::parse
    // 0xf0e628: r16 = 40
    //     0xf0e628: movz            x16, #0x28
    // 0xf0e62c: str             x16, [SP]
    // 0xf0e630: ldur            x1, [fp, #-0x10]
    // 0xf0e634: r2 = 18
    //     0xf0e634: movz            x2, #0x12
    // 0xf0e638: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e638: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e63c: r0 = substring()
    //     0xf0e63c: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e640: r16 = 32
    //     0xf0e640: movz            x16, #0x20
    // 0xf0e644: str             x16, [SP]
    // 0xf0e648: mov             x1, x0
    // 0xf0e64c: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf0e64c: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf0e650: ldr             x4, [x4, #0x128]
    // 0xf0e654: r0 = parse()
    //     0xf0e654: bl              #0x621868  ; [dart:core] int::parse
    // 0xf0e658: r16 = 356
    //     0xf0e658: movz            x16, #0x164
    // 0xf0e65c: str             x16, [SP]
    // 0xf0e660: ldur            x1, [fp, #-0x10]
    // 0xf0e664: r2 = 114
    //     0xf0e664: movz            x2, #0x72
    // 0xf0e668: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e668: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e66c: r0 = substring()
    //     0xf0e66c: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e670: r16 = 228
    //     0xf0e670: movz            x16, #0xe4
    // 0xf0e674: str             x16, [SP]
    // 0xf0e678: ldur            x1, [fp, #-0x10]
    // 0xf0e67c: r2 = 102
    //     0xf0e67c: movz            x2, #0x66
    // 0xf0e680: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e680: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e684: r0 = substring()
    //     0xf0e684: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e688: r16 = 200
    //     0xf0e688: movz            x16, #0xc8
    // 0xf0e68c: str             x16, [SP]
    // 0xf0e690: ldur            x1, [fp, #-0x10]
    // 0xf0e694: r2 = 98
    //     0xf0e694: movz            x2, #0x62
    // 0xf0e698: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e698: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e69c: r0 = substring()
    //     0xf0e69c: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e6a0: r16 = 32
    //     0xf0e6a0: movz            x16, #0x20
    // 0xf0e6a4: str             x16, [SP]
    // 0xf0e6a8: mov             x1, x0
    // 0xf0e6ac: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf0e6ac: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf0e6b0: ldr             x4, [x4, #0x128]
    // 0xf0e6b4: r0 = parse()
    //     0xf0e6b4: bl              #0x621868  ; [dart:core] int::parse
    // 0xf0e6b8: r16 = 204
    //     0xf0e6b8: movz            x16, #0xcc
    // 0xf0e6bc: str             x16, [SP]
    // 0xf0e6c0: ldur            x1, [fp, #-0x10]
    // 0xf0e6c4: r2 = 100
    //     0xf0e6c4: movz            x2, #0x64
    // 0xf0e6c8: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e6c8: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e6cc: r0 = substring()
    //     0xf0e6cc: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e6d0: r16 = 32
    //     0xf0e6d0: movz            x16, #0x20
    // 0xf0e6d4: str             x16, [SP]
    // 0xf0e6d8: mov             x1, x0
    // 0xf0e6dc: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf0e6dc: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf0e6e0: ldr             x4, [x4, #0x128]
    // 0xf0e6e4: r0 = parse()
    //     0xf0e6e4: bl              #0x621868  ; [dart:core] int::parse
    // 0xf0e6e8: ldur            x0, [fp, #-8]
    // 0xf0e6ec: LoadField: r1 = r0->field_7
    //     0xf0e6ec: ldur            w1, [x0, #7]
    // 0xf0e6f0: DecompressPointer r1
    //     0xf0e6f0: add             x1, x1, HEAP, lsl #32
    // 0xf0e6f4: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0e6f8: cmp             w1, w16
    // 0xf0e6fc: b.eq            #0xf0e730
    // 0xf0e700: r0 = LoadClassIdInstr(r1)
    //     0xf0e700: ldur            x0, [x1, #-1]
    //     0xf0e704: ubfx            x0, x0, #0xc, #0x14
    // 0xf0e708: r0 = GDT[cid_x0 + 0x5d44]()
    //     0xf0e708: movz            x17, #0x5d44
    //     0xf0e70c: add             lr, x0, x17
    //     0xf0e710: ldr             lr, [x21, lr, lsl #3]
    //     0xf0e714: blr             lr
    // 0xf0e718: r0 = Null
    //     0xf0e718: mov             x0, NULL
    // 0xf0e71c: LeaveFrame
    //     0xf0e71c: mov             SP, fp
    //     0xf0e720: ldp             fp, lr, [SP], #0x10
    // 0xf0e724: ret
    //     0xf0e724: ret             
    // 0xf0e728: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0e728: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0e72c: b               #0xf0e56c
    // 0xf0e730: r9 = receiveHandler
    //     0xf0e730: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf0e734: ldr             x9, [x9, #0x4a8]
    // 0xf0e738: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf0e738: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleMultiDevice(/* No info */) {
    // ** addr: 0xf0e73c, size: 0x108
    // 0xf0e73c: EnterFrame
    //     0xf0e73c: stp             fp, lr, [SP, #-0x10]!
    //     0xf0e740: mov             fp, SP
    // 0xf0e744: AllocStack(0x28)
    //     0xf0e744: sub             SP, SP, #0x28
    // 0xf0e748: SetupParameters(ZTReceiver this /* r1 => r1, fp-0x8 */, dynamic _ /* r2 => r2, fp-0x10 */)
    //     0xf0e748: stur            x1, [fp, #-8]
    //     0xf0e74c: stur            x2, [fp, #-0x10]
    // 0xf0e750: CheckStackOverflow
    //     0xf0e750: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0e754: cmp             SP, x16
    //     0xf0e758: b.ls            #0xf0e830
    // 0xf0e75c: r0 = LoadStaticField(0x804)
    //     0xf0e75c: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0e760: ldr             x0, [x0, #0x1008]
    // 0xf0e764: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0e768: cmp             w0, w16
    // 0xf0e76c: b.ne            #0xf0e778
    // 0xf0e770: r2 = rsbt
    //     0xf0e770: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0e774: r0 = InitLateFinalStaticField()
    //     0xf0e774: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0e778: LoadField: r3 = r0->field_1f
    //     0xf0e778: ldur            w3, [x0, #0x1f]
    // 0xf0e77c: DecompressPointer r3
    //     0xf0e77c: add             x3, x3, HEAP, lsl #32
    // 0xf0e780: stur            x3, [fp, #-0x18]
    // 0xf0e784: r1 = Null
    //     0xf0e784: mov             x1, NULL
    // 0xf0e788: r2 = 4
    //     0xf0e788: movz            x2, #0x4
    // 0xf0e78c: r0 = AllocateArray()
    //     0xf0e78c: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0e790: r16 = "一拖二数据获取到了 "
    //     0xf0e790: add             x16, PP, #0x12, lsl #12  ; [pp+0x124b8] "一拖二数据获取到了 "
    //     0xf0e794: ldr             x16, [x16, #0x4b8]
    // 0xf0e798: StoreField: r0->field_f = r16
    //     0xf0e798: stur            w16, [x0, #0xf]
    // 0xf0e79c: ldur            x1, [fp, #-0x10]
    // 0xf0e7a0: StoreField: r0->field_13 = r1
    //     0xf0e7a0: stur            w1, [x0, #0x13]
    // 0xf0e7a4: str             x0, [SP]
    // 0xf0e7a8: r0 = _interpolate()
    //     0xf0e7a8: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0e7ac: ldur            x1, [fp, #-0x18]
    // 0xf0e7b0: mov             x2, x0
    // 0xf0e7b4: r0 = i()
    //     0xf0e7b4: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xf0e7b8: ldur            x0, [fp, #-8]
    // 0xf0e7bc: LoadField: r1 = r0->field_7
    //     0xf0e7bc: ldur            w1, [x0, #7]
    // 0xf0e7c0: DecompressPointer r1
    //     0xf0e7c0: add             x1, x1, HEAP, lsl #32
    // 0xf0e7c4: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0e7c8: cmp             w1, w16
    // 0xf0e7cc: b.eq            #0xf0e838
    // 0xf0e7d0: ldur            x0, [fp, #-0x10]
    // 0xf0e7d4: stur            x1, [fp, #-0x18]
    // 0xf0e7d8: r2 = LoadClassIdInstr(r0)
    //     0xf0e7d8: ldur            x2, [x0, #-1]
    //     0xf0e7dc: ubfx            x2, x2, #0xc, #0x14
    // 0xf0e7e0: r16 = "1"
    //     0xf0e7e0: add             x16, PP, #0x10, lsl #12  ; [pp+0x10248] "1"
    //     0xf0e7e4: ldr             x16, [x16, #0x248]
    // 0xf0e7e8: stp             x16, x0, [SP]
    // 0xf0e7ec: mov             x0, x2
    // 0xf0e7f0: mov             lr, x0
    // 0xf0e7f4: ldr             lr, [x21, lr, lsl #3]
    // 0xf0e7f8: blr             lr
    // 0xf0e7fc: ldur            x1, [fp, #-0x18]
    // 0xf0e800: r2 = LoadClassIdInstr(r1)
    //     0xf0e800: ldur            x2, [x1, #-1]
    //     0xf0e804: ubfx            x2, x2, #0xc, #0x14
    // 0xf0e808: mov             x16, x0
    // 0xf0e80c: mov             x0, x2
    // 0xf0e810: mov             x2, x16
    // 0xf0e814: r0 = GDT[cid_x0 + -0xa79]()
    //     0xf0e814: sub             lr, x0, #0xa79
    //     0xf0e818: ldr             lr, [x21, lr, lsl #3]
    //     0xf0e81c: blr             lr
    // 0xf0e820: r0 = Null
    //     0xf0e820: mov             x0, NULL
    // 0xf0e824: LeaveFrame
    //     0xf0e824: mov             SP, fp
    //     0xf0e828: ldp             fp, lr, [SP], #0x10
    // 0xf0e82c: ret
    //     0xf0e82c: ret             
    // 0xf0e830: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0e830: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0e834: b               #0xf0e75c
    // 0xf0e838: r9 = receiveHandler
    //     0xf0e838: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf0e83c: ldr             x9, [x9, #0x4a8]
    // 0xf0e840: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf0e840: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleAncList(/* No info */) {
    // ** addr: 0xf0e844, size: 0x324
    // 0xf0e844: EnterFrame
    //     0xf0e844: stp             fp, lr, [SP, #-0x10]!
    //     0xf0e848: mov             fp, SP
    // 0xf0e84c: AllocStack(0x48)
    //     0xf0e84c: sub             SP, SP, #0x48
    // 0xf0e850: SetupParameters(ZTReceiver this /* r1 => r0, fp-0x8 */, dynamic _ /* r2 => r1, fp-0x10 */)
    //     0xf0e850: mov             x0, x1
    //     0xf0e854: stur            x1, [fp, #-8]
    //     0xf0e858: mov             x1, x2
    //     0xf0e85c: stur            x2, [fp, #-0x10]
    // 0xf0e860: CheckStackOverflow
    //     0xf0e860: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0e864: cmp             SP, x16
    //     0xf0e868: b.ls            #0xf0eb54
    // 0xf0e86c: r0 = LoadStaticField(0x804)
    //     0xf0e86c: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0e870: ldr             x0, [x0, #0x1008]
    // 0xf0e874: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0e878: cmp             w0, w16
    // 0xf0e87c: b.ne            #0xf0e888
    // 0xf0e880: r2 = rsbt
    //     0xf0e880: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0e884: r0 = InitLateFinalStaticField()
    //     0xf0e884: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0e888: stur            x0, [fp, #-0x20]
    // 0xf0e88c: LoadField: r3 = r0->field_1f
    //     0xf0e88c: ldur            w3, [x0, #0x1f]
    // 0xf0e890: DecompressPointer r3
    //     0xf0e890: add             x3, x3, HEAP, lsl #32
    // 0xf0e894: stur            x3, [fp, #-0x18]
    // 0xf0e898: r1 = Null
    //     0xf0e898: mov             x1, NULL
    // 0xf0e89c: r2 = 4
    //     0xf0e89c: movz            x2, #0x4
    // 0xf0e8a0: r0 = AllocateArray()
    //     0xf0e8a0: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0e8a4: r16 = "ANC列表数据获取到了 "
    //     0xf0e8a4: add             x16, PP, #0x12, lsl #12  ; [pp+0x124c0] "ANC列表数据获取到了 "
    //     0xf0e8a8: ldr             x16, [x16, #0x4c0]
    // 0xf0e8ac: StoreField: r0->field_f = r16
    //     0xf0e8ac: stur            w16, [x0, #0xf]
    // 0xf0e8b0: ldur            x1, [fp, #-0x10]
    // 0xf0e8b4: StoreField: r0->field_13 = r1
    //     0xf0e8b4: stur            w1, [x0, #0x13]
    // 0xf0e8b8: str             x0, [SP]
    // 0xf0e8bc: r0 = _interpolate()
    //     0xf0e8bc: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0e8c0: ldur            x1, [fp, #-0x18]
    // 0xf0e8c4: mov             x2, x0
    // 0xf0e8c8: r0 = i()
    //     0xf0e8c8: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xf0e8cc: r16 = 2
    //     0xf0e8cc: movz            x16, #0x2
    // 0xf0e8d0: str             x16, [SP]
    // 0xf0e8d4: ldur            x1, [fp, #-0x10]
    // 0xf0e8d8: r2 = 0
    //     0xf0e8d8: movz            x2, #0
    // 0xf0e8dc: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e8dc: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e8e0: r0 = substring()
    //     0xf0e8e0: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e8e4: r16 = 32
    //     0xf0e8e4: movz            x16, #0x20
    // 0xf0e8e8: str             x16, [SP]
    // 0xf0e8ec: mov             x1, x0
    // 0xf0e8f0: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf0e8f0: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf0e8f4: ldr             x4, [x4, #0x128]
    // 0xf0e8f8: r0 = parse()
    //     0xf0e8f8: bl              #0x621868  ; [dart:core] int::parse
    // 0xf0e8fc: stur            x0, [fp, #-0x28]
    // 0xf0e900: r16 = 6
    //     0xf0e900: movz            x16, #0x6
    // 0xf0e904: str             x16, [SP]
    // 0xf0e908: ldur            x1, [fp, #-0x10]
    // 0xf0e90c: r2 = 2
    //     0xf0e90c: movz            x2, #0x2
    // 0xf0e910: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e910: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e914: r0 = substring()
    //     0xf0e914: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e918: r16 = 32
    //     0xf0e918: movz            x16, #0x20
    // 0xf0e91c: str             x16, [SP]
    // 0xf0e920: mov             x1, x0
    // 0xf0e924: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf0e924: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf0e928: ldr             x4, [x4, #0x128]
    // 0xf0e92c: r0 = parse()
    //     0xf0e92c: bl              #0x621868  ; [dart:core] int::parse
    // 0xf0e930: stur            x0, [fp, #-0x30]
    // 0xf0e934: r16 = 10
    //     0xf0e934: movz            x16, #0xa
    // 0xf0e938: str             x16, [SP]
    // 0xf0e93c: ldur            x1, [fp, #-0x10]
    // 0xf0e940: r2 = 4
    //     0xf0e940: movz            x2, #0x4
    // 0xf0e944: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e944: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e948: r0 = substring()
    //     0xf0e948: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e94c: r16 = 32
    //     0xf0e94c: movz            x16, #0x20
    // 0xf0e950: str             x16, [SP]
    // 0xf0e954: mov             x1, x0
    // 0xf0e958: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf0e958: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf0e95c: ldr             x4, [x4, #0x128]
    // 0xf0e960: r0 = parse()
    //     0xf0e960: bl              #0x621868  ; [dart:core] int::parse
    // 0xf0e964: stur            x0, [fp, #-0x38]
    // 0xf0e968: r16 = 14
    //     0xf0e968: movz            x16, #0xe
    // 0xf0e96c: str             x16, [SP]
    // 0xf0e970: ldur            x1, [fp, #-0x10]
    // 0xf0e974: r2 = 6
    //     0xf0e974: movz            x2, #0x6
    // 0xf0e978: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0e978: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0e97c: r0 = substring()
    //     0xf0e97c: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0e980: r16 = 32
    //     0xf0e980: movz            x16, #0x20
    // 0xf0e984: str             x16, [SP]
    // 0xf0e988: mov             x1, x0
    // 0xf0e98c: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf0e98c: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf0e990: ldr             x4, [x4, #0x128]
    // 0xf0e994: r0 = parse()
    //     0xf0e994: bl              #0x621868  ; [dart:core] int::parse
    // 0xf0e998: mov             x3, x0
    // 0xf0e99c: ldur            x0, [fp, #-0x20]
    // 0xf0e9a0: stur            x3, [fp, #-0x40]
    // 0xf0e9a4: LoadField: r4 = r0->field_1f
    //     0xf0e9a4: ldur            w4, [x0, #0x1f]
    // 0xf0e9a8: DecompressPointer r4
    //     0xf0e9a8: add             x4, x4, HEAP, lsl #32
    // 0xf0e9ac: stur            x4, [fp, #-0x18]
    // 0xf0e9b0: r1 = Null
    //     0xf0e9b0: mov             x1, NULL
    // 0xf0e9b4: r2 = 20
    //     0xf0e9b4: movz            x2, #0x14
    // 0xf0e9b8: r0 = AllocateArray()
    //     0xf0e9b8: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0e9bc: mov             x2, x0
    // 0xf0e9c0: r16 = "降噪链表获取到了"
    //     0xf0e9c0: add             x16, PP, #0x12, lsl #12  ; [pp+0x124c8] "降噪链表获取到了"
    //     0xf0e9c4: ldr             x16, [x16, #0x4c8]
    // 0xf0e9c8: StoreField: r2->field_f = r16
    //     0xf0e9c8: stur            w16, [x2, #0xf]
    // 0xf0e9cc: ldur            x0, [fp, #-0x10]
    // 0xf0e9d0: StoreField: r2->field_13 = r0
    //     0xf0e9d0: stur            w0, [x2, #0x13]
    // 0xf0e9d4: r16 = " "
    //     0xf0e9d4: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xf0e9d8: ArrayStore: r2[0] = r16  ; List_4
    //     0xf0e9d8: stur            w16, [x2, #0x17]
    // 0xf0e9dc: ldur            x3, [fp, #-0x28]
    // 0xf0e9e0: r0 = BoxInt64Instr(r3)
    //     0xf0e9e0: sbfiz           x0, x3, #1, #0x1f
    //     0xf0e9e4: cmp             x3, x0, asr #1
    //     0xf0e9e8: b.eq            #0xf0e9f4
    //     0xf0e9ec: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xf0e9f0: stur            x3, [x0, #7]
    // 0xf0e9f4: mov             x1, x2
    // 0xf0e9f8: ArrayStore: r1[3] = r0  ; List_4
    //     0xf0e9f8: add             x25, x1, #0x1b
    //     0xf0e9fc: str             w0, [x25]
    //     0xf0ea00: tbz             w0, #0, #0xf0ea1c
    //     0xf0ea04: ldurb           w16, [x1, #-1]
    //     0xf0ea08: ldurb           w17, [x0, #-1]
    //     0xf0ea0c: and             x16, x17, x16, lsr #2
    //     0xf0ea10: tst             x16, HEAP, lsr #32
    //     0xf0ea14: b.eq            #0xf0ea1c
    //     0xf0ea18: bl              #0xf1cde4  ; ArrayWriteBarrierStub
    // 0xf0ea1c: r16 = " "
    //     0xf0ea1c: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xf0ea20: StoreField: r2->field_1f = r16
    //     0xf0ea20: stur            w16, [x2, #0x1f]
    // 0xf0ea24: ldur            x4, [fp, #-0x30]
    // 0xf0ea28: r0 = BoxInt64Instr(r4)
    //     0xf0ea28: sbfiz           x0, x4, #1, #0x1f
    //     0xf0ea2c: cmp             x4, x0, asr #1
    //     0xf0ea30: b.eq            #0xf0ea3c
    //     0xf0ea34: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xf0ea38: stur            x4, [x0, #7]
    // 0xf0ea3c: mov             x1, x2
    // 0xf0ea40: ArrayStore: r1[5] = r0  ; List_4
    //     0xf0ea40: add             x25, x1, #0x23
    //     0xf0ea44: str             w0, [x25]
    //     0xf0ea48: tbz             w0, #0, #0xf0ea64
    //     0xf0ea4c: ldurb           w16, [x1, #-1]
    //     0xf0ea50: ldurb           w17, [x0, #-1]
    //     0xf0ea54: and             x16, x17, x16, lsr #2
    //     0xf0ea58: tst             x16, HEAP, lsr #32
    //     0xf0ea5c: b.eq            #0xf0ea64
    //     0xf0ea60: bl              #0xf1cde4  ; ArrayWriteBarrierStub
    // 0xf0ea64: r16 = " "
    //     0xf0ea64: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xf0ea68: StoreField: r2->field_27 = r16
    //     0xf0ea68: stur            w16, [x2, #0x27]
    // 0xf0ea6c: ldur            x5, [fp, #-0x38]
    // 0xf0ea70: r0 = BoxInt64Instr(r5)
    //     0xf0ea70: sbfiz           x0, x5, #1, #0x1f
    //     0xf0ea74: cmp             x5, x0, asr #1
    //     0xf0ea78: b.eq            #0xf0ea84
    //     0xf0ea7c: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xf0ea80: stur            x5, [x0, #7]
    // 0xf0ea84: mov             x1, x2
    // 0xf0ea88: ArrayStore: r1[7] = r0  ; List_4
    //     0xf0ea88: add             x25, x1, #0x2b
    //     0xf0ea8c: str             w0, [x25]
    //     0xf0ea90: tbz             w0, #0, #0xf0eaac
    //     0xf0ea94: ldurb           w16, [x1, #-1]
    //     0xf0ea98: ldurb           w17, [x0, #-1]
    //     0xf0ea9c: and             x16, x17, x16, lsr #2
    //     0xf0eaa0: tst             x16, HEAP, lsr #32
    //     0xf0eaa4: b.eq            #0xf0eaac
    //     0xf0eaa8: bl              #0xf1cde4  ; ArrayWriteBarrierStub
    // 0xf0eaac: r16 = " "
    //     0xf0eaac: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xf0eab0: StoreField: r2->field_2f = r16
    //     0xf0eab0: stur            w16, [x2, #0x2f]
    // 0xf0eab4: ldur            x6, [fp, #-0x40]
    // 0xf0eab8: r0 = BoxInt64Instr(r6)
    //     0xf0eab8: sbfiz           x0, x6, #1, #0x1f
    //     0xf0eabc: cmp             x6, x0, asr #1
    //     0xf0eac0: b.eq            #0xf0eacc
    //     0xf0eac4: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xf0eac8: stur            x6, [x0, #7]
    // 0xf0eacc: mov             x1, x2
    // 0xf0ead0: ArrayStore: r1[9] = r0  ; List_4
    //     0xf0ead0: add             x25, x1, #0x33
    //     0xf0ead4: str             w0, [x25]
    //     0xf0ead8: tbz             w0, #0, #0xf0eaf4
    //     0xf0eadc: ldurb           w16, [x1, #-1]
    //     0xf0eae0: ldurb           w17, [x0, #-1]
    //     0xf0eae4: and             x16, x17, x16, lsr #2
    //     0xf0eae8: tst             x16, HEAP, lsr #32
    //     0xf0eaec: b.eq            #0xf0eaf4
    //     0xf0eaf0: bl              #0xf1cde4  ; ArrayWriteBarrierStub
    // 0xf0eaf4: str             x2, [SP]
    // 0xf0eaf8: r0 = _interpolate()
    //     0xf0eaf8: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0eafc: ldur            x1, [fp, #-0x18]
    // 0xf0eb00: mov             x2, x0
    // 0xf0eb04: r0 = i()
    //     0xf0eb04: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xf0eb08: ldur            x0, [fp, #-8]
    // 0xf0eb0c: LoadField: r1 = r0->field_7
    //     0xf0eb0c: ldur            w1, [x0, #7]
    // 0xf0eb10: DecompressPointer r1
    //     0xf0eb10: add             x1, x1, HEAP, lsl #32
    // 0xf0eb14: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0eb18: cmp             w1, w16
    // 0xf0eb1c: b.eq            #0xf0eb5c
    // 0xf0eb20: r0 = LoadClassIdInstr(r1)
    //     0xf0eb20: ldur            x0, [x1, #-1]
    //     0xf0eb24: ubfx            x0, x0, #0xc, #0x14
    // 0xf0eb28: ldur            x2, [fp, #-0x28]
    // 0xf0eb2c: ldur            x3, [fp, #-0x30]
    // 0xf0eb30: ldur            x5, [fp, #-0x38]
    // 0xf0eb34: ldur            x6, [fp, #-0x40]
    // 0xf0eb38: r0 = GDT[cid_x0 + -0xa15]()
    //     0xf0eb38: sub             lr, x0, #0xa15
    //     0xf0eb3c: ldr             lr, [x21, lr, lsl #3]
    //     0xf0eb40: blr             lr
    // 0xf0eb44: r0 = Null
    //     0xf0eb44: mov             x0, NULL
    // 0xf0eb48: LeaveFrame
    //     0xf0eb48: mov             SP, fp
    //     0xf0eb4c: ldp             fp, lr, [SP], #0x10
    // 0xf0eb50: ret
    //     0xf0eb50: ret             
    // 0xf0eb54: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0eb54: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0eb58: b               #0xf0e86c
    // 0xf0eb5c: r9 = receiveHandler
    //     0xf0eb5c: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf0eb60: ldr             x9, [x9, #0x4a8]
    // 0xf0eb64: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf0eb64: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleEarFind(/* No info */) {
    // ** addr: 0xf0eb68, size: 0xd0
    // 0xf0eb68: EnterFrame
    //     0xf0eb68: stp             fp, lr, [SP, #-0x10]!
    //     0xf0eb6c: mov             fp, SP
    // 0xf0eb70: AllocStack(0x20)
    //     0xf0eb70: sub             SP, SP, #0x20
    // 0xf0eb74: SetupParameters(ZTReceiver this /* r1 => r1, fp-0x8 */, dynamic _ /* r2 => r2, fp-0x10 */)
    //     0xf0eb74: stur            x1, [fp, #-8]
    //     0xf0eb78: stur            x2, [fp, #-0x10]
    // 0xf0eb7c: CheckStackOverflow
    //     0xf0eb7c: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0eb80: cmp             SP, x16
    //     0xf0eb84: b.ls            #0xf0ec24
    // 0xf0eb88: r0 = LoadStaticField(0x804)
    //     0xf0eb88: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0eb8c: ldr             x0, [x0, #0x1008]
    // 0xf0eb90: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0eb94: cmp             w0, w16
    // 0xf0eb98: b.ne            #0xf0eba4
    // 0xf0eb9c: r2 = rsbt
    //     0xf0eb9c: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0eba0: r0 = InitLateFinalStaticField()
    //     0xf0eba0: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0eba4: LoadField: r3 = r0->field_1f
    //     0xf0eba4: ldur            w3, [x0, #0x1f]
    // 0xf0eba8: DecompressPointer r3
    //     0xf0eba8: add             x3, x3, HEAP, lsl #32
    // 0xf0ebac: stur            x3, [fp, #-0x18]
    // 0xf0ebb0: r1 = Null
    //     0xf0ebb0: mov             x1, NULL
    // 0xf0ebb4: r2 = 4
    //     0xf0ebb4: movz            x2, #0x4
    // 0xf0ebb8: r0 = AllocateArray()
    //     0xf0ebb8: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0ebbc: r16 = "耳机查找数据获取到了 "
    //     0xf0ebbc: add             x16, PP, #0x12, lsl #12  ; [pp+0x124d0] "耳机查找数据获取到了 "
    //     0xf0ebc0: ldr             x16, [x16, #0x4d0]
    // 0xf0ebc4: StoreField: r0->field_f = r16
    //     0xf0ebc4: stur            w16, [x0, #0xf]
    // 0xf0ebc8: ldur            x2, [fp, #-0x10]
    // 0xf0ebcc: StoreField: r0->field_13 = r2
    //     0xf0ebcc: stur            w2, [x0, #0x13]
    // 0xf0ebd0: str             x0, [SP]
    // 0xf0ebd4: r0 = _interpolate()
    //     0xf0ebd4: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0ebd8: ldur            x1, [fp, #-0x18]
    // 0xf0ebdc: mov             x2, x0
    // 0xf0ebe0: r0 = i()
    //     0xf0ebe0: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xf0ebe4: ldur            x0, [fp, #-8]
    // 0xf0ebe8: LoadField: r1 = r0->field_7
    //     0xf0ebe8: ldur            w1, [x0, #7]
    // 0xf0ebec: DecompressPointer r1
    //     0xf0ebec: add             x1, x1, HEAP, lsl #32
    // 0xf0ebf0: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0ebf4: cmp             w1, w16
    // 0xf0ebf8: b.eq            #0xf0ec2c
    // 0xf0ebfc: r0 = LoadClassIdInstr(r1)
    //     0xf0ebfc: ldur            x0, [x1, #-1]
    //     0xf0ec00: ubfx            x0, x0, #0xc, #0x14
    // 0xf0ec04: ldur            x2, [fp, #-0x10]
    // 0xf0ec08: r0 = GDT[cid_x0 + -0x9f4]()
    //     0xf0ec08: sub             lr, x0, #0x9f4
    //     0xf0ec0c: ldr             lr, [x21, lr, lsl #3]
    //     0xf0ec10: blr             lr
    // 0xf0ec14: r0 = Null
    //     0xf0ec14: mov             x0, NULL
    // 0xf0ec18: LeaveFrame
    //     0xf0ec18: mov             SP, fp
    //     0xf0ec1c: ldp             fp, lr, [SP], #0x10
    // 0xf0ec20: ret
    //     0xf0ec20: ret             
    // 0xf0ec24: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0ec24: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0ec28: b               #0xf0eb88
    // 0xf0ec2c: r9 = receiveHandler
    //     0xf0ec2c: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf0ec30: ldr             x9, [x9, #0x4a8]
    // 0xf0ec34: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf0ec34: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleTouchControl(/* No info */) {
    // ** addr: 0xf0ec38, size: 0x104
    // 0xf0ec38: EnterFrame
    //     0xf0ec38: stp             fp, lr, [SP, #-0x10]!
    //     0xf0ec3c: mov             fp, SP
    // 0xf0ec40: AllocStack(0x28)
    //     0xf0ec40: sub             SP, SP, #0x28
    // 0xf0ec44: SetupParameters(ZTReceiver this /* r1 => r1, fp-0x8 */, dynamic _ /* r2 => r2, fp-0x10 */)
    //     0xf0ec44: stur            x1, [fp, #-8]
    //     0xf0ec48: stur            x2, [fp, #-0x10]
    // 0xf0ec4c: CheckStackOverflow
    //     0xf0ec4c: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0ec50: cmp             SP, x16
    //     0xf0ec54: b.ls            #0xf0ed28
    // 0xf0ec58: r0 = LoadStaticField(0x804)
    //     0xf0ec58: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0ec5c: ldr             x0, [x0, #0x1008]
    // 0xf0ec60: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0ec64: cmp             w0, w16
    // 0xf0ec68: b.ne            #0xf0ec74
    // 0xf0ec6c: r2 = rsbt
    //     0xf0ec6c: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0ec70: r0 = InitLateFinalStaticField()
    //     0xf0ec70: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0ec74: LoadField: r3 = r0->field_1f
    //     0xf0ec74: ldur            w3, [x0, #0x1f]
    // 0xf0ec78: DecompressPointer r3
    //     0xf0ec78: add             x3, x3, HEAP, lsl #32
    // 0xf0ec7c: stur            x3, [fp, #-0x18]
    // 0xf0ec80: r1 = Null
    //     0xf0ec80: mov             x1, NULL
    // 0xf0ec84: r2 = 4
    //     0xf0ec84: movz            x2, #0x4
    // 0xf0ec88: r0 = AllocateArray()
    //     0xf0ec88: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0ec8c: r16 = "触控功能 "
    //     0xf0ec8c: add             x16, PP, #0x12, lsl #12  ; [pp+0x124d8] "触控功能 "
    //     0xf0ec90: ldr             x16, [x16, #0x4d8]
    // 0xf0ec94: StoreField: r0->field_f = r16
    //     0xf0ec94: stur            w16, [x0, #0xf]
    // 0xf0ec98: ldur            x1, [fp, #-0x10]
    // 0xf0ec9c: StoreField: r0->field_13 = r1
    //     0xf0ec9c: stur            w1, [x0, #0x13]
    // 0xf0eca0: str             x0, [SP]
    // 0xf0eca4: r0 = _interpolate()
    //     0xf0eca4: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0eca8: ldur            x1, [fp, #-0x18]
    // 0xf0ecac: mov             x2, x0
    // 0xf0ecb0: r0 = i()
    //     0xf0ecb0: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xf0ecb4: ldur            x0, [fp, #-8]
    // 0xf0ecb8: LoadField: r1 = r0->field_7
    //     0xf0ecb8: ldur            w1, [x0, #7]
    // 0xf0ecbc: DecompressPointer r1
    //     0xf0ecbc: add             x1, x1, HEAP, lsl #32
    // 0xf0ecc0: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0ecc4: cmp             w1, w16
    // 0xf0ecc8: b.eq            #0xf0ed30
    // 0xf0eccc: ldur            x0, [fp, #-0x10]
    // 0xf0ecd0: stur            x1, [fp, #-0x18]
    // 0xf0ecd4: r2 = LoadClassIdInstr(r0)
    //     0xf0ecd4: ldur            x2, [x0, #-1]
    //     0xf0ecd8: ubfx            x2, x2, #0xc, #0x14
    // 0xf0ecdc: r16 = "0"
    //     0xf0ecdc: ldr             x16, [PP, #0x45f8]  ; [pp+0x45f8] "0"
    // 0xf0ece0: stp             x16, x0, [SP]
    // 0xf0ece4: mov             x0, x2
    // 0xf0ece8: mov             lr, x0
    // 0xf0ecec: ldr             lr, [x21, lr, lsl #3]
    // 0xf0ecf0: blr             lr
    // 0xf0ecf4: ldur            x1, [fp, #-0x18]
    // 0xf0ecf8: r2 = LoadClassIdInstr(r1)
    //     0xf0ecf8: ldur            x2, [x1, #-1]
    //     0xf0ecfc: ubfx            x2, x2, #0xc, #0x14
    // 0xf0ed00: mov             x16, x0
    // 0xf0ed04: mov             x0, x2
    // 0xf0ed08: mov             x2, x16
    // 0xf0ed0c: r0 = GDT[cid_x0 + -0xec2]()
    //     0xf0ed0c: sub             lr, x0, #0xec2
    //     0xf0ed10: ldr             lr, [x21, lr, lsl #3]
    //     0xf0ed14: blr             lr
    // 0xf0ed18: r0 = Null
    //     0xf0ed18: mov             x0, NULL
    // 0xf0ed1c: LeaveFrame
    //     0xf0ed1c: mov             SP, fp
    //     0xf0ed20: ldp             fp, lr, [SP], #0x10
    // 0xf0ed24: ret
    //     0xf0ed24: ret             
    // 0xf0ed28: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0ed28: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0ed2c: b               #0xf0ec58
    // 0xf0ed30: r9 = receiveHandler
    //     0xf0ed30: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf0ed34: ldr             x9, [x9, #0x4a8]
    // 0xf0ed38: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf0ed38: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handlePromptToneLevelHeadfree(/* No info */) {
    // ** addr: 0xf0ed3c, size: 0x104
    // 0xf0ed3c: EnterFrame
    //     0xf0ed3c: stp             fp, lr, [SP, #-0x10]!
    //     0xf0ed40: mov             fp, SP
    // 0xf0ed44: AllocStack(0x20)
    //     0xf0ed44: sub             SP, SP, #0x20
    // 0xf0ed48: SetupParameters(ZTReceiver this /* r1 => r0, fp-0x8 */, dynamic _ /* r2 => r1 */)
    //     0xf0ed48: mov             x0, x1
    //     0xf0ed4c: stur            x1, [fp, #-8]
    //     0xf0ed50: mov             x1, x2
    // 0xf0ed54: CheckStackOverflow
    //     0xf0ed54: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0ed58: cmp             SP, x16
    //     0xf0ed5c: b.ls            #0xf0ee2c
    // 0xf0ed60: r16 = 32
    //     0xf0ed60: movz            x16, #0x20
    // 0xf0ed64: str             x16, [SP]
    // 0xf0ed68: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf0ed68: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf0ed6c: ldr             x4, [x4, #0x128]
    // 0xf0ed70: r0 = parse()
    //     0xf0ed70: bl              #0x621868  ; [dart:core] int::parse
    // 0xf0ed74: stur            x0, [fp, #-0x10]
    // 0xf0ed78: r0 = LoadStaticField(0x804)
    //     0xf0ed78: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0ed7c: ldr             x0, [x0, #0x1008]
    // 0xf0ed80: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0ed84: cmp             w0, w16
    // 0xf0ed88: b.ne            #0xf0ed94
    // 0xf0ed8c: r2 = rsbt
    //     0xf0ed8c: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0ed90: r0 = InitLateFinalStaticField()
    //     0xf0ed90: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0ed94: LoadField: r3 = r0->field_1f
    //     0xf0ed94: ldur            w3, [x0, #0x1f]
    // 0xf0ed98: DecompressPointer r3
    //     0xf0ed98: add             x3, x3, HEAP, lsl #32
    // 0xf0ed9c: stur            x3, [fp, #-0x18]
    // 0xf0eda0: r1 = Null
    //     0xf0eda0: mov             x1, NULL
    // 0xf0eda4: r2 = 4
    //     0xf0eda4: movz            x2, #0x4
    // 0xf0eda8: r0 = AllocateArray()
    //     0xf0eda8: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0edac: mov             x2, x0
    // 0xf0edb0: r16 = "提示音等级数据获取到了 "
    //     0xf0edb0: add             x16, PP, #0x12, lsl #12  ; [pp+0x124e0] "提示音等级数据获取到了 "
    //     0xf0edb4: ldr             x16, [x16, #0x4e0]
    // 0xf0edb8: StoreField: r2->field_f = r16
    //     0xf0edb8: stur            w16, [x2, #0xf]
    // 0xf0edbc: ldur            x3, [fp, #-0x10]
    // 0xf0edc0: r0 = BoxInt64Instr(r3)
    //     0xf0edc0: sbfiz           x0, x3, #1, #0x1f
    //     0xf0edc4: cmp             x3, x0, asr #1
    //     0xf0edc8: b.eq            #0xf0edd4
    //     0xf0edcc: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xf0edd0: stur            x3, [x0, #7]
    // 0xf0edd4: StoreField: r2->field_13 = r0
    //     0xf0edd4: stur            w0, [x2, #0x13]
    // 0xf0edd8: str             x2, [SP]
    // 0xf0eddc: r0 = _interpolate()
    //     0xf0eddc: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0ede0: ldur            x1, [fp, #-0x18]
    // 0xf0ede4: mov             x2, x0
    // 0xf0ede8: r0 = i()
    //     0xf0ede8: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xf0edec: ldur            x0, [fp, #-8]
    // 0xf0edf0: LoadField: r1 = r0->field_7
    //     0xf0edf0: ldur            w1, [x0, #7]
    // 0xf0edf4: DecompressPointer r1
    //     0xf0edf4: add             x1, x1, HEAP, lsl #32
    // 0xf0edf8: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0edfc: cmp             w1, w16
    // 0xf0ee00: b.eq            #0xf0ee34
    // 0xf0ee04: r0 = LoadClassIdInstr(r1)
    //     0xf0ee04: ldur            x0, [x1, #-1]
    //     0xf0ee08: ubfx            x0, x0, #0xc, #0x14
    // 0xf0ee0c: ldur            x2, [fp, #-0x10]
    // 0xf0ee10: r0 = GDT[cid_x0 + -0xf61]()
    //     0xf0ee10: sub             lr, x0, #0xf61
    //     0xf0ee14: ldr             lr, [x21, lr, lsl #3]
    //     0xf0ee18: blr             lr
    // 0xf0ee1c: r0 = Null
    //     0xf0ee1c: mov             x0, NULL
    // 0xf0ee20: LeaveFrame
    //     0xf0ee20: mov             SP, fp
    //     0xf0ee24: ldp             fp, lr, [SP], #0x10
    // 0xf0ee28: ret
    //     0xf0ee28: ret             
    // 0xf0ee2c: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0ee2c: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0ee30: b               #0xf0ed60
    // 0xf0ee34: r9 = receiveHandler
    //     0xf0ee34: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf0ee38: ldr             x9, [x9, #0x4a8]
    // 0xf0ee3c: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf0ee3c: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handlePromptToneLevel(/* No info */) {
    // ** addr: 0xf0ee40, size: 0x108
    // 0xf0ee40: EnterFrame
    //     0xf0ee40: stp             fp, lr, [SP, #-0x10]!
    //     0xf0ee44: mov             fp, SP
    // 0xf0ee48: AllocStack(0x20)
    //     0xf0ee48: sub             SP, SP, #0x20
    // 0xf0ee4c: SetupParameters(ZTReceiver this /* r1 => r0, fp-0x8 */, dynamic _ /* r2 => r1 */)
    //     0xf0ee4c: mov             x0, x1
    //     0xf0ee50: stur            x1, [fp, #-8]
    //     0xf0ee54: mov             x1, x2
    // 0xf0ee58: CheckStackOverflow
    //     0xf0ee58: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0ee5c: cmp             SP, x16
    //     0xf0ee60: b.ls            #0xf0ef34
    // 0xf0ee64: r16 = 32
    //     0xf0ee64: movz            x16, #0x20
    // 0xf0ee68: str             x16, [SP]
    // 0xf0ee6c: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf0ee6c: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf0ee70: ldr             x4, [x4, #0x128]
    // 0xf0ee74: r0 = parse()
    //     0xf0ee74: bl              #0x621868  ; [dart:core] int::parse
    // 0xf0ee78: add             x2, x0, #1
    // 0xf0ee7c: stur            x2, [fp, #-0x10]
    // 0xf0ee80: r0 = LoadStaticField(0x804)
    //     0xf0ee80: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0ee84: ldr             x0, [x0, #0x1008]
    // 0xf0ee88: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0ee8c: cmp             w0, w16
    // 0xf0ee90: b.ne            #0xf0ee9c
    // 0xf0ee94: r2 = rsbt
    //     0xf0ee94: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0ee98: r0 = InitLateFinalStaticField()
    //     0xf0ee98: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0ee9c: LoadField: r3 = r0->field_1f
    //     0xf0ee9c: ldur            w3, [x0, #0x1f]
    // 0xf0eea0: DecompressPointer r3
    //     0xf0eea0: add             x3, x3, HEAP, lsl #32
    // 0xf0eea4: stur            x3, [fp, #-0x18]
    // 0xf0eea8: r1 = Null
    //     0xf0eea8: mov             x1, NULL
    // 0xf0eeac: r2 = 4
    //     0xf0eeac: movz            x2, #0x4
    // 0xf0eeb0: r0 = AllocateArray()
    //     0xf0eeb0: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0eeb4: mov             x2, x0
    // 0xf0eeb8: r16 = "提示音等级数据获取到了 "
    //     0xf0eeb8: add             x16, PP, #0x12, lsl #12  ; [pp+0x124e0] "提示音等级数据获取到了 "
    //     0xf0eebc: ldr             x16, [x16, #0x4e0]
    // 0xf0eec0: StoreField: r2->field_f = r16
    //     0xf0eec0: stur            w16, [x2, #0xf]
    // 0xf0eec4: ldur            x3, [fp, #-0x10]
    // 0xf0eec8: r0 = BoxInt64Instr(r3)
    //     0xf0eec8: sbfiz           x0, x3, #1, #0x1f
    //     0xf0eecc: cmp             x3, x0, asr #1
    //     0xf0eed0: b.eq            #0xf0eedc
    //     0xf0eed4: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xf0eed8: stur            x3, [x0, #7]
    // 0xf0eedc: StoreField: r2->field_13 = r0
    //     0xf0eedc: stur            w0, [x2, #0x13]
    // 0xf0eee0: str             x2, [SP]
    // 0xf0eee4: r0 = _interpolate()
    //     0xf0eee4: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0eee8: ldur            x1, [fp, #-0x18]
    // 0xf0eeec: mov             x2, x0
    // 0xf0eef0: r0 = i()
    //     0xf0eef0: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xf0eef4: ldur            x0, [fp, #-8]
    // 0xf0eef8: LoadField: r1 = r0->field_7
    //     0xf0eef8: ldur            w1, [x0, #7]
    // 0xf0eefc: DecompressPointer r1
    //     0xf0eefc: add             x1, x1, HEAP, lsl #32
    // 0xf0ef00: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0ef04: cmp             w1, w16
    // 0xf0ef08: b.eq            #0xf0ef3c
    // 0xf0ef0c: r0 = LoadClassIdInstr(r1)
    //     0xf0ef0c: ldur            x0, [x1, #-1]
    //     0xf0ef10: ubfx            x0, x0, #0xc, #0x14
    // 0xf0ef14: ldur            x2, [fp, #-0x10]
    // 0xf0ef18: r0 = GDT[cid_x0 + -0xf61]()
    //     0xf0ef18: sub             lr, x0, #0xf61
    //     0xf0ef1c: ldr             lr, [x21, lr, lsl #3]
    //     0xf0ef20: blr             lr
    // 0xf0ef24: r0 = Null
    //     0xf0ef24: mov             x0, NULL
    // 0xf0ef28: LeaveFrame
    //     0xf0ef28: mov             SP, fp
    //     0xf0ef2c: ldp             fp, lr, [SP], #0x10
    // 0xf0ef30: ret
    //     0xf0ef30: ret             
    // 0xf0ef34: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0ef34: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0ef38: b               #0xf0ee64
    // 0xf0ef3c: r9 = receiveHandler
    //     0xf0ef3c: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf0ef40: ldr             x9, [x9, #0x4a8]
    // 0xf0ef44: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf0ef44: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleTransparencyLevel(/* No info */) {
    // ** addr: 0xf0ef48, size: 0xf8
    // 0xf0ef48: EnterFrame
    //     0xf0ef48: stp             fp, lr, [SP, #-0x10]!
    //     0xf0ef4c: mov             fp, SP
    // 0xf0ef50: AllocStack(0x20)
    //     0xf0ef50: sub             SP, SP, #0x20
    // 0xf0ef54: SetupParameters(ZTReceiver this /* r1 => r0, fp-0x8 */, dynamic _ /* r2 => r1, fp-0x10 */)
    //     0xf0ef54: mov             x0, x1
    //     0xf0ef58: stur            x1, [fp, #-8]
    //     0xf0ef5c: mov             x1, x2
    //     0xf0ef60: stur            x2, [fp, #-0x10]
    // 0xf0ef64: CheckStackOverflow
    //     0xf0ef64: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0ef68: cmp             SP, x16
    //     0xf0ef6c: b.ls            #0xf0f02c
    // 0xf0ef70: r0 = LoadStaticField(0x804)
    //     0xf0ef70: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0ef74: ldr             x0, [x0, #0x1008]
    // 0xf0ef78: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0ef7c: cmp             w0, w16
    // 0xf0ef80: b.ne            #0xf0ef8c
    // 0xf0ef84: r2 = rsbt
    //     0xf0ef84: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0ef88: r0 = InitLateFinalStaticField()
    //     0xf0ef88: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0ef8c: LoadField: r3 = r0->field_1f
    //     0xf0ef8c: ldur            w3, [x0, #0x1f]
    // 0xf0ef90: DecompressPointer r3
    //     0xf0ef90: add             x3, x3, HEAP, lsl #32
    // 0xf0ef94: stur            x3, [fp, #-0x18]
    // 0xf0ef98: r1 = Null
    //     0xf0ef98: mov             x1, NULL
    // 0xf0ef9c: r2 = 4
    //     0xf0ef9c: movz            x2, #0x4
    // 0xf0efa0: r0 = AllocateArray()
    //     0xf0efa0: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0efa4: r16 = "通透等级数据获取到了 "
    //     0xf0efa4: add             x16, PP, #0x12, lsl #12  ; [pp+0x124e8] "通透等级数据获取到了 "
    //     0xf0efa8: ldr             x16, [x16, #0x4e8]
    // 0xf0efac: StoreField: r0->field_f = r16
    //     0xf0efac: stur            w16, [x0, #0xf]
    // 0xf0efb0: ldur            x1, [fp, #-0x10]
    // 0xf0efb4: StoreField: r0->field_13 = r1
    //     0xf0efb4: stur            w1, [x0, #0x13]
    // 0xf0efb8: str             x0, [SP]
    // 0xf0efbc: r0 = _interpolate()
    //     0xf0efbc: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0efc0: ldur            x1, [fp, #-0x18]
    // 0xf0efc4: mov             x2, x0
    // 0xf0efc8: r0 = i()
    //     0xf0efc8: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xf0efcc: ldur            x0, [fp, #-8]
    // 0xf0efd0: LoadField: r2 = r0->field_7
    //     0xf0efd0: ldur            w2, [x0, #7]
    // 0xf0efd4: DecompressPointer r2
    //     0xf0efd4: add             x2, x2, HEAP, lsl #32
    // 0xf0efd8: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0efdc: cmp             w2, w16
    // 0xf0efe0: b.eq            #0xf0f034
    // 0xf0efe4: ldur            x1, [fp, #-0x10]
    // 0xf0efe8: stur            x2, [fp, #-0x18]
    // 0xf0efec: r4 = const [0, 0x1, 0, 0x1, null]
    //     0xf0efec: ldr             x4, [PP, #0x470]  ; [pp+0x470] List(5) [0, 0x1, 0, 0x1, Null]
    // 0xf0eff0: r0 = parse()
    //     0xf0eff0: bl              #0x621868  ; [dart:core] int::parse
    // 0xf0eff4: ldur            x1, [fp, #-0x18]
    // 0xf0eff8: r2 = LoadClassIdInstr(r1)
    //     0xf0eff8: ldur            x2, [x1, #-1]
    //     0xf0effc: ubfx            x2, x2, #0xc, #0x14
    // 0xf0f000: mov             x16, x0
    // 0xf0f004: mov             x0, x2
    // 0xf0f008: mov             x2, x16
    // 0xf0f00c: ldur            x3, [fp, #-0x10]
    // 0xf0f010: r0 = GDT[cid_x0 + -0xb60]()
    //     0xf0f010: sub             lr, x0, #0xb60
    //     0xf0f014: ldr             lr, [x21, lr, lsl #3]
    //     0xf0f018: blr             lr
    // 0xf0f01c: r0 = Null
    //     0xf0f01c: mov             x0, NULL
    // 0xf0f020: LeaveFrame
    //     0xf0f020: mov             SP, fp
    //     0xf0f024: ldp             fp, lr, [SP], #0x10
    // 0xf0f028: ret
    //     0xf0f028: ret             
    // 0xf0f02c: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0f02c: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0f030: b               #0xf0ef70
    // 0xf0f034: r9 = receiveHandler
    //     0xf0f034: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf0f038: ldr             x9, [x9, #0x4a8]
    // 0xf0f03c: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf0f03c: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleANCLevel(/* No info */) {
    // ** addr: 0xf0f040, size: 0xf8
    // 0xf0f040: EnterFrame
    //     0xf0f040: stp             fp, lr, [SP, #-0x10]!
    //     0xf0f044: mov             fp, SP
    // 0xf0f048: AllocStack(0x20)
    //     0xf0f048: sub             SP, SP, #0x20
    // 0xf0f04c: SetupParameters(ZTReceiver this /* r1 => r0, fp-0x8 */, dynamic _ /* r2 => r1, fp-0x10 */)
    //     0xf0f04c: mov             x0, x1
    //     0xf0f050: stur            x1, [fp, #-8]
    //     0xf0f054: mov             x1, x2
    //     0xf0f058: stur            x2, [fp, #-0x10]
    // 0xf0f05c: CheckStackOverflow
    //     0xf0f05c: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0f060: cmp             SP, x16
    //     0xf0f064: b.ls            #0xf0f124
    // 0xf0f068: r0 = LoadStaticField(0x804)
    //     0xf0f068: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0f06c: ldr             x0, [x0, #0x1008]
    // 0xf0f070: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0f074: cmp             w0, w16
    // 0xf0f078: b.ne            #0xf0f084
    // 0xf0f07c: r2 = rsbt
    //     0xf0f07c: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0f080: r0 = InitLateFinalStaticField()
    //     0xf0f080: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0f084: LoadField: r3 = r0->field_1f
    //     0xf0f084: ldur            w3, [x0, #0x1f]
    // 0xf0f088: DecompressPointer r3
    //     0xf0f088: add             x3, x3, HEAP, lsl #32
    // 0xf0f08c: stur            x3, [fp, #-0x18]
    // 0xf0f090: r1 = Null
    //     0xf0f090: mov             x1, NULL
    // 0xf0f094: r2 = 4
    //     0xf0f094: movz            x2, #0x4
    // 0xf0f098: r0 = AllocateArray()
    //     0xf0f098: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0f09c: r16 = "降噪等级数据获取到了 "
    //     0xf0f09c: add             x16, PP, #0x12, lsl #12  ; [pp+0x124f0] "降噪等级数据获取到了 "
    //     0xf0f0a0: ldr             x16, [x16, #0x4f0]
    // 0xf0f0a4: StoreField: r0->field_f = r16
    //     0xf0f0a4: stur            w16, [x0, #0xf]
    // 0xf0f0a8: ldur            x1, [fp, #-0x10]
    // 0xf0f0ac: StoreField: r0->field_13 = r1
    //     0xf0f0ac: stur            w1, [x0, #0x13]
    // 0xf0f0b0: str             x0, [SP]
    // 0xf0f0b4: r0 = _interpolate()
    //     0xf0f0b4: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0f0b8: ldur            x1, [fp, #-0x18]
    // 0xf0f0bc: mov             x2, x0
    // 0xf0f0c0: r0 = i()
    //     0xf0f0c0: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xf0f0c4: ldur            x0, [fp, #-8]
    // 0xf0f0c8: LoadField: r2 = r0->field_7
    //     0xf0f0c8: ldur            w2, [x0, #7]
    // 0xf0f0cc: DecompressPointer r2
    //     0xf0f0cc: add             x2, x2, HEAP, lsl #32
    // 0xf0f0d0: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0f0d4: cmp             w2, w16
    // 0xf0f0d8: b.eq            #0xf0f12c
    // 0xf0f0dc: ldur            x1, [fp, #-0x10]
    // 0xf0f0e0: stur            x2, [fp, #-0x18]
    // 0xf0f0e4: r4 = const [0, 0x1, 0, 0x1, null]
    //     0xf0f0e4: ldr             x4, [PP, #0x470]  ; [pp+0x470] List(5) [0, 0x1, 0, 0x1, Null]
    // 0xf0f0e8: r0 = parse()
    //     0xf0f0e8: bl              #0x621868  ; [dart:core] int::parse
    // 0xf0f0ec: ldur            x1, [fp, #-0x18]
    // 0xf0f0f0: r2 = LoadClassIdInstr(r1)
    //     0xf0f0f0: ldur            x2, [x1, #-1]
    //     0xf0f0f4: ubfx            x2, x2, #0xc, #0x14
    // 0xf0f0f8: mov             x16, x0
    // 0xf0f0fc: mov             x0, x2
    // 0xf0f100: mov             x2, x16
    // 0xf0f104: ldur            x3, [fp, #-0x10]
    // 0xf0f108: r0 = GDT[cid_x0 + -0xb6e]()
    //     0xf0f108: sub             lr, x0, #0xb6e
    //     0xf0f10c: ldr             lr, [x21, lr, lsl #3]
    //     0xf0f110: blr             lr
    // 0xf0f114: r0 = Null
    //     0xf0f114: mov             x0, NULL
    // 0xf0f118: LeaveFrame
    //     0xf0f118: mov             SP, fp
    //     0xf0f11c: ldp             fp, lr, [SP], #0x10
    // 0xf0f120: ret
    //     0xf0f120: ret             
    // 0xf0f124: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0f124: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0f128: b               #0xf0f068
    // 0xf0f12c: r9 = receiveHandler
    //     0xf0f12c: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf0f130: ldr             x9, [x9, #0x4a8]
    // 0xf0f134: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf0f134: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleANCData(/* No info */) {
    // ** addr: 0xf0f138, size: 0x1dc
    // 0xf0f138: EnterFrame
    //     0xf0f138: stp             fp, lr, [SP, #-0x10]!
    //     0xf0f13c: mov             fp, SP
    // 0xf0f140: AllocStack(0x30)
    //     0xf0f140: sub             SP, SP, #0x30
    // 0xf0f144: SetupParameters(ZTReceiver this /* r1 => r1, fp-0x8 */, dynamic _ /* r2 => r2, fp-0x10 */)
    //     0xf0f144: stur            x1, [fp, #-8]
    //     0xf0f148: stur            x2, [fp, #-0x10]
    // 0xf0f14c: CheckStackOverflow
    //     0xf0f14c: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0f150: cmp             SP, x16
    //     0xf0f154: b.ls            #0xf0f300
    // 0xf0f158: r0 = LoadStaticField(0x804)
    //     0xf0f158: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0f15c: ldr             x0, [x0, #0x1008]
    // 0xf0f160: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0f164: cmp             w0, w16
    // 0xf0f168: b.ne            #0xf0f174
    // 0xf0f16c: r2 = rsbt
    //     0xf0f16c: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0f170: r0 = InitLateFinalStaticField()
    //     0xf0f170: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0f174: stur            x0, [fp, #-0x20]
    // 0xf0f178: LoadField: r3 = r0->field_1f
    //     0xf0f178: ldur            w3, [x0, #0x1f]
    // 0xf0f17c: DecompressPointer r3
    //     0xf0f17c: add             x3, x3, HEAP, lsl #32
    // 0xf0f180: stur            x3, [fp, #-0x18]
    // 0xf0f184: r1 = Null
    //     0xf0f184: mov             x1, NULL
    // 0xf0f188: r2 = 4
    //     0xf0f188: movz            x2, #0x4
    // 0xf0f18c: r0 = AllocateArray()
    //     0xf0f18c: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0f190: r16 = "降噪数据获取到了 "
    //     0xf0f190: add             x16, PP, #0x12, lsl #12  ; [pp+0x124f8] "降噪数据获取到了 "
    //     0xf0f194: ldr             x16, [x16, #0x4f8]
    // 0xf0f198: StoreField: r0->field_f = r16
    //     0xf0f198: stur            w16, [x0, #0xf]
    // 0xf0f19c: ldur            x2, [fp, #-0x10]
    // 0xf0f1a0: StoreField: r0->field_13 = r2
    //     0xf0f1a0: stur            w2, [x0, #0x13]
    // 0xf0f1a4: str             x0, [SP]
    // 0xf0f1a8: r0 = _interpolate()
    //     0xf0f1a8: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0f1ac: ldur            x1, [fp, #-0x18]
    // 0xf0f1b0: mov             x2, x0
    // 0xf0f1b4: r0 = i()
    //     0xf0f1b4: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xf0f1b8: r1 = Null
    //     0xf0f1b8: mov             x1, NULL
    // 0xf0f1bc: r2 = 20
    //     0xf0f1bc: movz            x2, #0x14
    // 0xf0f1c0: r0 = AllocateArray()
    //     0xf0f1c0: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0f1c4: r16 = "0001000020"
    //     0xf0f1c4: add             x16, PP, #0x12, lsl #12  ; [pp+0x12500] "0001000020"
    //     0xf0f1c8: ldr             x16, [x16, #0x500]
    // 0xf0f1cc: StoreField: r0->field_f = r16
    //     0xf0f1cc: stur            w16, [x0, #0xf]
    // 0xf0f1d0: StoreField: r0->field_13 = rZR
    //     0xf0f1d0: stur            wzr, [x0, #0x13]
    // 0xf0f1d4: r16 = "0100000020"
    //     0xf0f1d4: add             x16, PP, #0x12, lsl #12  ; [pp+0x12508] "0100000020"
    //     0xf0f1d8: ldr             x16, [x16, #0x508]
    // 0xf0f1dc: ArrayStore: r0[0] = r16  ; List_4
    //     0xf0f1dc: stur            w16, [x0, #0x17]
    // 0xf0f1e0: r16 = 6
    //     0xf0f1e0: movz            x16, #0x6
    // 0xf0f1e4: StoreField: r0->field_1b = r16
    //     0xf0f1e4: stur            w16, [x0, #0x1b]
    // 0xf0f1e8: r16 = "0000000120"
    //     0xf0f1e8: add             x16, PP, #0x12, lsl #12  ; [pp+0x12510] "0000000120"
    //     0xf0f1ec: ldr             x16, [x16, #0x510]
    // 0xf0f1f0: StoreField: r0->field_1f = r16
    //     0xf0f1f0: stur            w16, [x0, #0x1f]
    // 0xf0f1f4: r16 = 2
    //     0xf0f1f4: movz            x16, #0x2
    // 0xf0f1f8: StoreField: r0->field_23 = r16
    //     0xf0f1f8: stur            w16, [x0, #0x23]
    // 0xf0f1fc: r16 = "0000010020"
    //     0xf0f1fc: add             x16, PP, #0x12, lsl #12  ; [pp+0x12518] "0000010020"
    //     0xf0f200: ldr             x16, [x16, #0x518]
    // 0xf0f204: StoreField: r0->field_27 = r16
    //     0xf0f204: stur            w16, [x0, #0x27]
    // 0xf0f208: r16 = 4
    //     0xf0f208: movz            x16, #0x4
    // 0xf0f20c: StoreField: r0->field_2b = r16
    //     0xf0f20c: stur            w16, [x0, #0x2b]
    // 0xf0f210: r16 = "0200000021"
    //     0xf0f210: add             x16, PP, #0x12, lsl #12  ; [pp+0x12520] "0200000021"
    //     0xf0f214: ldr             x16, [x16, #0x520]
    // 0xf0f218: StoreField: r0->field_2f = r16
    //     0xf0f218: stur            w16, [x0, #0x2f]
    // 0xf0f21c: r16 = 8
    //     0xf0f21c: movz            x16, #0x8
    // 0xf0f220: StoreField: r0->field_33 = r16
    //     0xf0f220: stur            w16, [x0, #0x33]
    // 0xf0f224: r16 = <String, int>
    //     0xf0f224: ldr             x16, [PP, #0x718]  ; [pp+0x718] TypeArguments: <String, int>
    // 0xf0f228: stp             x0, x16, [SP]
    // 0xf0f22c: r0 = Map._fromLiteral()
    //     0xf0f22c: bl              #0x5f9f50  ; [dart:core] Map::Map._fromLiteral
    // 0xf0f230: r1 = LoadClassIdInstr(r0)
    //     0xf0f230: ldur            x1, [x0, #-1]
    //     0xf0f234: ubfx            x1, x1, #0xc, #0x14
    // 0xf0f238: mov             x16, x0
    // 0xf0f23c: mov             x0, x1
    // 0xf0f240: mov             x1, x16
    // 0xf0f244: ldur            x2, [fp, #-0x10]
    // 0xf0f248: r0 = GDT[cid_x0 + -0xa94]()
    //     0xf0f248: sub             lr, x0, #0xa94
    //     0xf0f24c: ldr             lr, [x21, lr, lsl #3]
    //     0xf0f250: blr             lr
    // 0xf0f254: cmp             w0, NULL
    // 0xf0f258: b.ne            #0xf0f2b0
    // 0xf0f25c: ldur            x3, [fp, #-0x10]
    // 0xf0f260: ldur            x0, [fp, #-0x20]
    // 0xf0f264: LoadField: r4 = r0->field_1f
    //     0xf0f264: ldur            w4, [x0, #0x1f]
    // 0xf0f268: DecompressPointer r4
    //     0xf0f268: add             x4, x4, HEAP, lsl #32
    // 0xf0f26c: stur            x4, [fp, #-0x18]
    // 0xf0f270: r1 = Null
    //     0xf0f270: mov             x1, NULL
    // 0xf0f274: r2 = 4
    //     0xf0f274: movz            x2, #0x4
    // 0xf0f278: r0 = AllocateArray()
    //     0xf0f278: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0f27c: r16 = "[noiseMode]降噪数据超出处理范围，需要确认数据是否正确 "
    //     0xf0f27c: add             x16, PP, #0x12, lsl #12  ; [pp+0x12528] "[noiseMode]降噪数据超出处理范围，需要确认数据是否正确 "
    //     0xf0f280: ldr             x16, [x16, #0x528]
    // 0xf0f284: StoreField: r0->field_f = r16
    //     0xf0f284: stur            w16, [x0, #0xf]
    // 0xf0f288: ldur            x3, [fp, #-0x10]
    // 0xf0f28c: StoreField: r0->field_13 = r3
    //     0xf0f28c: stur            w3, [x0, #0x13]
    // 0xf0f290: str             x0, [SP]
    // 0xf0f294: r0 = _interpolate()
    //     0xf0f294: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0f298: ldur            x1, [fp, #-0x18]
    // 0xf0f29c: mov             x2, x0
    // 0xf0f2a0: r4 = const [0, 0x2, 0, 0x2, null]
    //     0xf0f2a0: ldr             x4, [PP, #0x5b0]  ; [pp+0x5b0] List(5) [0, 0x2, 0, 0x2, Null]
    // 0xf0f2a4: r0 = w()
    //     0xf0f2a4: bl              #0x6bf3f0  ; [package:logger/src/logger.dart] Logger::w
    // 0xf0f2a8: r2 = 0
    //     0xf0f2a8: movz            x2, #0
    // 0xf0f2ac: b               #0xf0f2c0
    // 0xf0f2b0: r1 = LoadInt32Instr(r0)
    //     0xf0f2b0: sbfx            x1, x0, #1, #0x1f
    //     0xf0f2b4: tbz             w0, #0, #0xf0f2bc
    //     0xf0f2b8: ldur            x1, [x0, #7]
    // 0xf0f2bc: mov             x2, x1
    // 0xf0f2c0: ldur            x0, [fp, #-8]
    // 0xf0f2c4: LoadField: r1 = r0->field_7
    //     0xf0f2c4: ldur            w1, [x0, #7]
    // 0xf0f2c8: DecompressPointer r1
    //     0xf0f2c8: add             x1, x1, HEAP, lsl #32
    // 0xf0f2cc: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0f2d0: cmp             w1, w16
    // 0xf0f2d4: b.eq            #0xf0f308
    // 0xf0f2d8: r0 = LoadClassIdInstr(r1)
    //     0xf0f2d8: ldur            x0, [x1, #-1]
    //     0xf0f2dc: ubfx            x0, x0, #0xc, #0x14
    // 0xf0f2e0: ldur            x3, [fp, #-0x10]
    // 0xf0f2e4: r0 = GDT[cid_x0 + -0xf0b]()
    //     0xf0f2e4: sub             lr, x0, #0xf0b
    //     0xf0f2e8: ldr             lr, [x21, lr, lsl #3]
    //     0xf0f2ec: blr             lr
    // 0xf0f2f0: r0 = Null
    //     0xf0f2f0: mov             x0, NULL
    // 0xf0f2f4: LeaveFrame
    //     0xf0f2f4: mov             SP, fp
    //     0xf0f2f8: ldp             fp, lr, [SP], #0x10
    // 0xf0f2fc: ret
    //     0xf0f2fc: ret             
    // 0xf0f300: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0f300: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0f304: b               #0xf0f158
    // 0xf0f308: r9 = receiveHandler
    //     0xf0f308: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf0f30c: ldr             x9, [x9, #0x4a8]
    // 0xf0f310: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf0f310: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleConnectionMode(/* No info */) {
    // ** addr: 0xf0f314, size: 0x100
    // 0xf0f314: EnterFrame
    //     0xf0f314: stp             fp, lr, [SP, #-0x10]!
    //     0xf0f318: mov             fp, SP
    // 0xf0f31c: AllocStack(0x20)
    //     0xf0f31c: sub             SP, SP, #0x20
    // 0xf0f320: SetupParameters(ZTReceiver this /* r1 => r0, fp-0x8 */, dynamic _ /* r2 => r1, fp-0x10 */)
    //     0xf0f320: mov             x0, x1
    //     0xf0f324: stur            x1, [fp, #-8]
    //     0xf0f328: mov             x1, x2
    //     0xf0f32c: stur            x2, [fp, #-0x10]
    // 0xf0f330: CheckStackOverflow
    //     0xf0f330: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0f334: cmp             SP, x16
    //     0xf0f338: b.ls            #0xf0f400
    // 0xf0f33c: r0 = LoadStaticField(0x804)
    //     0xf0f33c: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0f340: ldr             x0, [x0, #0x1008]
    // 0xf0f344: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0f348: cmp             w0, w16
    // 0xf0f34c: b.ne            #0xf0f358
    // 0xf0f350: r2 = rsbt
    //     0xf0f350: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0f354: r0 = InitLateFinalStaticField()
    //     0xf0f354: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0f358: LoadField: r3 = r0->field_1f
    //     0xf0f358: ldur            w3, [x0, #0x1f]
    // 0xf0f35c: DecompressPointer r3
    //     0xf0f35c: add             x3, x3, HEAP, lsl #32
    // 0xf0f360: stur            x3, [fp, #-0x18]
    // 0xf0f364: r1 = Null
    //     0xf0f364: mov             x1, NULL
    // 0xf0f368: r2 = 4
    //     0xf0f368: movz            x2, #0x4
    // 0xf0f36c: r0 = AllocateArray()
    //     0xf0f36c: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0f370: r16 = "当前耳机支持模式为 "
    //     0xf0f370: add             x16, PP, #0x12, lsl #12  ; [pp+0x12530] "当前耳机支持模式为 "
    //     0xf0f374: ldr             x16, [x16, #0x530]
    // 0xf0f378: StoreField: r0->field_f = r16
    //     0xf0f378: stur            w16, [x0, #0xf]
    // 0xf0f37c: ldur            x1, [fp, #-0x10]
    // 0xf0f380: StoreField: r0->field_13 = r1
    //     0xf0f380: stur            w1, [x0, #0x13]
    // 0xf0f384: str             x0, [SP]
    // 0xf0f388: r0 = _interpolate()
    //     0xf0f388: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0f38c: ldur            x1, [fp, #-0x18]
    // 0xf0f390: mov             x2, x0
    // 0xf0f394: r0 = i()
    //     0xf0f394: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xf0f398: ldur            x0, [fp, #-8]
    // 0xf0f39c: LoadField: r2 = r0->field_7
    //     0xf0f39c: ldur            w2, [x0, #7]
    // 0xf0f3a0: DecompressPointer r2
    //     0xf0f3a0: add             x2, x2, HEAP, lsl #32
    // 0xf0f3a4: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0f3a8: cmp             w2, w16
    // 0xf0f3ac: b.eq            #0xf0f408
    // 0xf0f3b0: stur            x2, [fp, #-0x18]
    // 0xf0f3b4: r16 = 32
    //     0xf0f3b4: movz            x16, #0x20
    // 0xf0f3b8: str             x16, [SP]
    // 0xf0f3bc: ldur            x1, [fp, #-0x10]
    // 0xf0f3c0: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf0f3c0: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf0f3c4: ldr             x4, [x4, #0x128]
    // 0xf0f3c8: r0 = parse()
    //     0xf0f3c8: bl              #0x621868  ; [dart:core] int::parse
    // 0xf0f3cc: ldur            x1, [fp, #-0x18]
    // 0xf0f3d0: r2 = LoadClassIdInstr(r1)
    //     0xf0f3d0: ldur            x2, [x1, #-1]
    //     0xf0f3d4: ubfx            x2, x2, #0xc, #0x14
    // 0xf0f3d8: mov             x16, x0
    // 0xf0f3dc: mov             x0, x2
    // 0xf0f3e0: mov             x2, x16
    // 0xf0f3e4: r0 = GDT[cid_x0 + -0xb7c]()
    //     0xf0f3e4: sub             lr, x0, #0xb7c
    //     0xf0f3e8: ldr             lr, [x21, lr, lsl #3]
    //     0xf0f3ec: blr             lr
    // 0xf0f3f0: r0 = Null
    //     0xf0f3f0: mov             x0, NULL
    // 0xf0f3f4: LeaveFrame
    //     0xf0f3f4: mov             SP, fp
    //     0xf0f3f8: ldp             fp, lr, [SP], #0x10
    // 0xf0f3fc: ret
    //     0xf0f3fc: ret             
    // 0xf0f400: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0f400: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0f404: b               #0xf0f33c
    // 0xf0f408: r9 = receiveHandler
    //     0xf0f408: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf0f40c: ldr             x9, [x9, #0x4a8]
    // 0xf0f410: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf0f410: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleInEarDetection(/* No info */) {
    // ** addr: 0xf0f414, size: 0x104
    // 0xf0f414: EnterFrame
    //     0xf0f414: stp             fp, lr, [SP, #-0x10]!
    //     0xf0f418: mov             fp, SP
    // 0xf0f41c: AllocStack(0x28)
    //     0xf0f41c: sub             SP, SP, #0x28
    // 0xf0f420: SetupParameters(ZTReceiver this /* r1 => r1, fp-0x8 */, dynamic _ /* r2 => r2, fp-0x10 */)
    //     0xf0f420: stur            x1, [fp, #-8]
    //     0xf0f424: stur            x2, [fp, #-0x10]
    // 0xf0f428: CheckStackOverflow
    //     0xf0f428: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0f42c: cmp             SP, x16
    //     0xf0f430: b.ls            #0xf0f504
    // 0xf0f434: r0 = LoadStaticField(0x804)
    //     0xf0f434: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0f438: ldr             x0, [x0, #0x1008]
    // 0xf0f43c: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0f440: cmp             w0, w16
    // 0xf0f444: b.ne            #0xf0f450
    // 0xf0f448: r2 = rsbt
    //     0xf0f448: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0f44c: r0 = InitLateFinalStaticField()
    //     0xf0f44c: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0f450: LoadField: r3 = r0->field_1f
    //     0xf0f450: ldur            w3, [x0, #0x1f]
    // 0xf0f454: DecompressPointer r3
    //     0xf0f454: add             x3, x3, HEAP, lsl #32
    // 0xf0f458: stur            x3, [fp, #-0x18]
    // 0xf0f45c: r1 = Null
    //     0xf0f45c: mov             x1, NULL
    // 0xf0f460: r2 = 4
    //     0xf0f460: movz            x2, #0x4
    // 0xf0f464: r0 = AllocateArray()
    //     0xf0f464: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0f468: r16 = "入耳检测 "
    //     0xf0f468: add             x16, PP, #0x12, lsl #12  ; [pp+0x12538] "入耳检测 "
    //     0xf0f46c: ldr             x16, [x16, #0x538]
    // 0xf0f470: StoreField: r0->field_f = r16
    //     0xf0f470: stur            w16, [x0, #0xf]
    // 0xf0f474: ldur            x1, [fp, #-0x10]
    // 0xf0f478: StoreField: r0->field_13 = r1
    //     0xf0f478: stur            w1, [x0, #0x13]
    // 0xf0f47c: str             x0, [SP]
    // 0xf0f480: r0 = _interpolate()
    //     0xf0f480: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0f484: ldur            x1, [fp, #-0x18]
    // 0xf0f488: mov             x2, x0
    // 0xf0f48c: r0 = i()
    //     0xf0f48c: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xf0f490: ldur            x0, [fp, #-8]
    // 0xf0f494: LoadField: r1 = r0->field_7
    //     0xf0f494: ldur            w1, [x0, #7]
    // 0xf0f498: DecompressPointer r1
    //     0xf0f498: add             x1, x1, HEAP, lsl #32
    // 0xf0f49c: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0f4a0: cmp             w1, w16
    // 0xf0f4a4: b.eq            #0xf0f50c
    // 0xf0f4a8: ldur            x0, [fp, #-0x10]
    // 0xf0f4ac: stur            x1, [fp, #-0x18]
    // 0xf0f4b0: r2 = LoadClassIdInstr(r0)
    //     0xf0f4b0: ldur            x2, [x0, #-1]
    //     0xf0f4b4: ubfx            x2, x2, #0xc, #0x14
    // 0xf0f4b8: r16 = "0"
    //     0xf0f4b8: ldr             x16, [PP, #0x45f8]  ; [pp+0x45f8] "0"
    // 0xf0f4bc: stp             x16, x0, [SP]
    // 0xf0f4c0: mov             x0, x2
    // 0xf0f4c4: mov             lr, x0
    // 0xf0f4c8: ldr             lr, [x21, lr, lsl #3]
    // 0xf0f4cc: blr             lr
    // 0xf0f4d0: ldur            x1, [fp, #-0x18]
    // 0xf0f4d4: r2 = LoadClassIdInstr(r1)
    //     0xf0f4d4: ldur            x2, [x1, #-1]
    //     0xf0f4d8: ubfx            x2, x2, #0xc, #0x14
    // 0xf0f4dc: mov             x16, x0
    // 0xf0f4e0: mov             x0, x2
    // 0xf0f4e4: mov             x2, x16
    // 0xf0f4e8: r0 = GDT[cid_x0 + -0xeb4]()
    //     0xf0f4e8: sub             lr, x0, #0xeb4
    //     0xf0f4ec: ldr             lr, [x21, lr, lsl #3]
    //     0xf0f4f0: blr             lr
    // 0xf0f4f4: r0 = Null
    //     0xf0f4f4: mov             x0, NULL
    // 0xf0f4f8: LeaveFrame
    //     0xf0f4f8: mov             SP, fp
    //     0xf0f4fc: ldp             fp, lr, [SP], #0x10
    // 0xf0f500: ret
    //     0xf0f500: ret             
    // 0xf0f504: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0f504: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0f508: b               #0xf0f434
    // 0xf0f50c: r9 = receiveHandler
    //     0xf0f50c: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf0f510: ldr             x9, [x9, #0x4a8]
    // 0xf0f514: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf0f514: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleGameMode(/* No info */) {
    // ** addr: 0xf0f518, size: 0x104
    // 0xf0f518: EnterFrame
    //     0xf0f518: stp             fp, lr, [SP, #-0x10]!
    //     0xf0f51c: mov             fp, SP
    // 0xf0f520: AllocStack(0x28)
    //     0xf0f520: sub             SP, SP, #0x28
    // 0xf0f524: SetupParameters(ZTReceiver this /* r1 => r1, fp-0x8 */, dynamic _ /* r2 => r2, fp-0x10 */)
    //     0xf0f524: stur            x1, [fp, #-8]
    //     0xf0f528: stur            x2, [fp, #-0x10]
    // 0xf0f52c: CheckStackOverflow
    //     0xf0f52c: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0f530: cmp             SP, x16
    //     0xf0f534: b.ls            #0xf0f608
    // 0xf0f538: r0 = LoadStaticField(0x804)
    //     0xf0f538: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0f53c: ldr             x0, [x0, #0x1008]
    // 0xf0f540: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0f544: cmp             w0, w16
    // 0xf0f548: b.ne            #0xf0f554
    // 0xf0f54c: r2 = rsbt
    //     0xf0f54c: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0f550: r0 = InitLateFinalStaticField()
    //     0xf0f550: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0f554: LoadField: r3 = r0->field_1f
    //     0xf0f554: ldur            w3, [x0, #0x1f]
    // 0xf0f558: DecompressPointer r3
    //     0xf0f558: add             x3, x3, HEAP, lsl #32
    // 0xf0f55c: stur            x3, [fp, #-0x18]
    // 0xf0f560: r1 = Null
    //     0xf0f560: mov             x1, NULL
    // 0xf0f564: r2 = 4
    //     0xf0f564: movz            x2, #0x4
    // 0xf0f568: r0 = AllocateArray()
    //     0xf0f568: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0f56c: r16 = "游戏模式 "
    //     0xf0f56c: add             x16, PP, #0x12, lsl #12  ; [pp+0x12540] "游戏模式 "
    //     0xf0f570: ldr             x16, [x16, #0x540]
    // 0xf0f574: StoreField: r0->field_f = r16
    //     0xf0f574: stur            w16, [x0, #0xf]
    // 0xf0f578: ldur            x1, [fp, #-0x10]
    // 0xf0f57c: StoreField: r0->field_13 = r1
    //     0xf0f57c: stur            w1, [x0, #0x13]
    // 0xf0f580: str             x0, [SP]
    // 0xf0f584: r0 = _interpolate()
    //     0xf0f584: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0f588: ldur            x1, [fp, #-0x18]
    // 0xf0f58c: mov             x2, x0
    // 0xf0f590: r0 = i()
    //     0xf0f590: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xf0f594: ldur            x0, [fp, #-8]
    // 0xf0f598: LoadField: r1 = r0->field_7
    //     0xf0f598: ldur            w1, [x0, #7]
    // 0xf0f59c: DecompressPointer r1
    //     0xf0f59c: add             x1, x1, HEAP, lsl #32
    // 0xf0f5a0: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0f5a4: cmp             w1, w16
    // 0xf0f5a8: b.eq            #0xf0f610
    // 0xf0f5ac: ldur            x0, [fp, #-0x10]
    // 0xf0f5b0: stur            x1, [fp, #-0x18]
    // 0xf0f5b4: r2 = LoadClassIdInstr(r0)
    //     0xf0f5b4: ldur            x2, [x0, #-1]
    //     0xf0f5b8: ubfx            x2, x2, #0xc, #0x14
    // 0xf0f5bc: r16 = "0"
    //     0xf0f5bc: ldr             x16, [PP, #0x45f8]  ; [pp+0x45f8] "0"
    // 0xf0f5c0: stp             x16, x0, [SP]
    // 0xf0f5c4: mov             x0, x2
    // 0xf0f5c8: mov             lr, x0
    // 0xf0f5cc: ldr             lr, [x21, lr, lsl #3]
    // 0xf0f5d0: blr             lr
    // 0xf0f5d4: ldur            x1, [fp, #-0x18]
    // 0xf0f5d8: r2 = LoadClassIdInstr(r1)
    //     0xf0f5d8: ldur            x2, [x1, #-1]
    //     0xf0f5dc: ubfx            x2, x2, #0xc, #0x14
    // 0xf0f5e0: mov             x16, x0
    // 0xf0f5e4: mov             x0, x2
    // 0xf0f5e8: mov             x2, x16
    // 0xf0f5ec: r0 = GDT[cid_x0 + -0xb8a]()
    //     0xf0f5ec: sub             lr, x0, #0xb8a
    //     0xf0f5f0: ldr             lr, [x21, lr, lsl #3]
    //     0xf0f5f4: blr             lr
    // 0xf0f5f8: r0 = Null
    //     0xf0f5f8: mov             x0, NULL
    // 0xf0f5fc: LeaveFrame
    //     0xf0f5fc: mov             SP, fp
    //     0xf0f600: ldp             fp, lr, [SP], #0x10
    // 0xf0f604: ret
    //     0xf0f604: ret             
    // 0xf0f608: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0f608: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0f60c: b               #0xf0f538
    // 0xf0f610: r9 = receiveHandler
    //     0xf0f610: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf0f614: ldr             x9, [x9, #0x4a8]
    // 0xf0f618: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf0f618: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleKeyData(/* No info */) {
    // ** addr: 0xf0f61c, size: 0x19c
    // 0xf0f61c: EnterFrame
    //     0xf0f61c: stp             fp, lr, [SP, #-0x10]!
    //     0xf0f620: mov             fp, SP
    // 0xf0f624: AllocStack(0x78)
    //     0xf0f624: sub             SP, SP, #0x78
    // 0xf0f628: SetupParameters(ZTReceiver this /* r1 => r1, fp-0x48 */, dynamic _ /* r2 => r2, fp-0x50 */)
    //     0xf0f628: stur            x1, [fp, #-0x48]
    //     0xf0f62c: stur            x2, [fp, #-0x50]
    // 0xf0f630: CheckStackOverflow
    //     0xf0f630: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0f634: cmp             SP, x16
    //     0xf0f638: b.ls            #0xf0f7a4
    // 0xf0f63c: r1 = 1
    //     0xf0f63c: movz            x1, #0x1
    // 0xf0f640: r0 = AllocateContext()
    //     0xf0f640: bl              #0xf1dacc  ; AllocateContextStub
    // 0xf0f644: mov             x1, x0
    // 0xf0f648: ldur            x0, [fp, #-0x50]
    // 0xf0f64c: stur            x1, [fp, #-0x58]
    // 0xf0f650: StoreField: r1->field_f = r0
    //     0xf0f650: stur            w0, [x1, #0xf]
    // 0xf0f654: r0 = LoadStaticField(0x804)
    //     0xf0f654: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0f658: ldr             x0, [x0, #0x1008]
    // 0xf0f65c: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0f660: cmp             w0, w16
    // 0xf0f664: b.ne            #0xf0f670
    // 0xf0f668: r2 = rsbt
    //     0xf0f668: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0f66c: r0 = InitLateFinalStaticField()
    //     0xf0f66c: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0f670: stur            x0, [fp, #-0x60]
    // 0xf0f674: LoadField: r3 = r0->field_1f
    //     0xf0f674: ldur            w3, [x0, #0x1f]
    // 0xf0f678: DecompressPointer r3
    //     0xf0f678: add             x3, x3, HEAP, lsl #32
    // 0xf0f67c: stur            x3, [fp, #-0x50]
    // 0xf0f680: r1 = Null
    //     0xf0f680: mov             x1, NULL
    // 0xf0f684: r2 = 4
    //     0xf0f684: movz            x2, #0x4
    // 0xf0f688: r0 = AllocateArray()
    //     0xf0f688: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0f68c: r16 = "按键数据获取到了 "
    //     0xf0f68c: add             x16, PP, #0x12, lsl #12  ; [pp+0x12548] "按键数据获取到了 "
    //     0xf0f690: ldr             x16, [x16, #0x548]
    // 0xf0f694: StoreField: r0->field_f = r16
    //     0xf0f694: stur            w16, [x0, #0xf]
    // 0xf0f698: ldur            x2, [fp, #-0x58]
    // 0xf0f69c: LoadField: r1 = r2->field_f
    //     0xf0f69c: ldur            w1, [x2, #0xf]
    // 0xf0f6a0: DecompressPointer r1
    //     0xf0f6a0: add             x1, x1, HEAP, lsl #32
    // 0xf0f6a4: StoreField: r0->field_13 = r1
    //     0xf0f6a4: stur            w1, [x0, #0x13]
    // 0xf0f6a8: str             x0, [SP]
    // 0xf0f6ac: r0 = _interpolate()
    //     0xf0f6ac: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0f6b0: ldur            x1, [fp, #-0x50]
    // 0xf0f6b4: mov             x2, x0
    // 0xf0f6b8: r0 = i()
    //     0xf0f6b8: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xf0f6bc: ldur            x3, [fp, #-0x48]
    // 0xf0f6c0: ldur            x0, [fp, #-0x58]
    // 0xf0f6c4: mov             x2, x0
    // 0xf0f6c8: r1 = Function '<anonymous closure>':.
    //     0xf0f6c8: add             x1, PP, #0x12, lsl #12  ; [pp+0x12550] AnonymousClosure: (0xf0f7b8), in [package:roselink_bluetooth/commander/receiver/zt_receiver.dart] ZTReceiver::_handleKeyData (0xf0f61c)
    //     0xf0f6cc: ldr             x1, [x1, #0x550]
    // 0xf0f6d0: r0 = AllocateClosure()
    //     0xf0f6d0: bl              #0xf1dea0  ; AllocateClosureStub
    // 0xf0f6d4: r16 = <int>
    //     0xf0f6d4: ldr             x16, [PP, #0x988]  ; [pp+0x988] TypeArguments: <int>
    // 0xf0f6d8: r30 = const [0x13, 0x15, 0x17, 0x19, 0x1b, 0x1d, 0x1f, 0x21]
    //     0xf0f6d8: add             lr, PP, #0x12, lsl #12  ; [pp+0x12558] List<int>(8)
    //     0xf0f6dc: ldr             lr, [lr, #0x558]
    // 0xf0f6e0: stp             lr, x16, [SP, #8]
    // 0xf0f6e4: str             x0, [SP]
    // 0xf0f6e8: r4 = const [0x1, 0x2, 0x2, 0x2, null]
    //     0xf0f6e8: ldr             x4, [PP, #0x40]  ; [pp+0x40] List(5) [0x1, 0x2, 0x2, 0x2, Null]
    // 0xf0f6ec: r0 = map()
    //     0xf0f6ec: bl              #0xc2fcc0  ; [dart:collection] ListBase::map
    // 0xf0f6f0: mov             x1, x0
    // 0xf0f6f4: r4 = const [0, 0x1, 0, 0x1, null]
    //     0xf0f6f4: ldr             x4, [PP, #0x470]  ; [pp+0x470] List(5) [0, 0x1, 0, 0x1, Null]
    // 0xf0f6f8: r0 = toList()
    //     0xf0f6f8: bl              #0x8fd2f4  ; [dart:_internal] ListIterable::toList
    // 0xf0f6fc: mov             x5, x0
    // 0xf0f700: ldur            x4, [fp, #-0x48]
    // 0xf0f704: stur            x5, [fp, #-0x50]
    // 0xf0f708: LoadField: r1 = r4->field_7
    //     0xf0f708: ldur            w1, [x4, #7]
    // 0xf0f70c: DecompressPointer r1
    //     0xf0f70c: add             x1, x1, HEAP, lsl #32
    // 0xf0f710: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0f714: cmp             w1, w16
    // 0xf0f718: b.eq            #0xf0f7ac
    // 0xf0f71c: ldur            x6, [fp, #-0x58]
    // 0xf0f720: LoadField: r3 = r6->field_f
    //     0xf0f720: ldur            w3, [x6, #0xf]
    // 0xf0f724: DecompressPointer r3
    //     0xf0f724: add             x3, x3, HEAP, lsl #32
    // 0xf0f728: r0 = LoadClassIdInstr(r1)
    //     0xf0f728: ldur            x0, [x1, #-1]
    //     0xf0f72c: ubfx            x0, x0, #0xc, #0x14
    // 0xf0f730: mov             x2, x5
    // 0xf0f734: r0 = GDT[cid_x0 + -0xef5]()
    //     0xf0f734: sub             lr, x0, #0xef5
    //     0xf0f738: ldr             lr, [x21, lr, lsl #3]
    //     0xf0f73c: blr             lr
    // 0xf0f740: b               #0xf0f794
    // 0xf0f744: sub             SP, fp, #0x78
    // 0xf0f748: ldur            x2, [fp, #-0x60]
    // 0xf0f74c: stur            x0, [fp, #-0x50]
    // 0xf0f750: LoadField: r3 = r2->field_1f
    //     0xf0f750: ldur            w3, [x2, #0x1f]
    // 0xf0f754: DecompressPointer r3
    //     0xf0f754: add             x3, x3, HEAP, lsl #32
    // 0xf0f758: stur            x3, [fp, #-0x48]
    // 0xf0f75c: r1 = Null
    //     0xf0f75c: mov             x1, NULL
    // 0xf0f760: r2 = 4
    //     0xf0f760: movz            x2, #0x4
    // 0xf0f764: r0 = AllocateArray()
    //     0xf0f764: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0f768: r16 = "处理按键数据时发生错误: "
    //     0xf0f768: add             x16, PP, #0x12, lsl #12  ; [pp+0x12560] "处理按键数据时发生错误: "
    //     0xf0f76c: ldr             x16, [x16, #0x560]
    // 0xf0f770: StoreField: r0->field_f = r16
    //     0xf0f770: stur            w16, [x0, #0xf]
    // 0xf0f774: ldur            x1, [fp, #-0x50]
    // 0xf0f778: StoreField: r0->field_13 = r1
    //     0xf0f778: stur            w1, [x0, #0x13]
    // 0xf0f77c: str             x0, [SP]
    // 0xf0f780: r0 = _interpolate()
    //     0xf0f780: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0f784: ldur            x1, [fp, #-0x48]
    // 0xf0f788: mov             x2, x0
    // 0xf0f78c: r4 = const [0, 0x2, 0, 0x2, null]
    //     0xf0f78c: ldr             x4, [PP, #0x5b0]  ; [pp+0x5b0] List(5) [0, 0x2, 0, 0x2, Null]
    // 0xf0f790: r0 = e()
    //     0xf0f790: bl              #0x6ea048  ; [package:logger/src/logger.dart] Logger::e
    // 0xf0f794: r0 = Null
    //     0xf0f794: mov             x0, NULL
    // 0xf0f798: LeaveFrame
    //     0xf0f798: mov             SP, fp
    //     0xf0f79c: ldp             fp, lr, [SP], #0x10
    // 0xf0f7a0: ret
    //     0xf0f7a0: ret             
    // 0xf0f7a4: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0f7a4: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0f7a8: b               #0xf0f63c
    // 0xf0f7ac: r9 = receiveHandler
    //     0xf0f7ac: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf0f7b0: ldr             x9, [x9, #0x4a8]
    // 0xf0f7b4: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf0f7b4: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  [closure] int <anonymous closure>(dynamic, int) {
    // ** addr: 0xf0f7b8, size: 0x128
    // 0xf0f7b8: EnterFrame
    //     0xf0f7b8: stp             fp, lr, [SP, #-0x10]!
    //     0xf0f7bc: mov             fp, SP
    // 0xf0f7c0: AllocStack(0x10)
    //     0xf0f7c0: sub             SP, SP, #0x10
    // 0xf0f7c4: SetupParameters([dynamic _ /* r0 */])
    //     0xf0f7c4: ldr             x0, [fp, #0x18]
    //     0xf0f7c8: ldur            w1, [x0, #0x17]
    //     0xf0f7cc: add             x1, x1, HEAP, lsl #32
    // 0xf0f7d0: CheckStackOverflow
    //     0xf0f7d0: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0f7d4: cmp             SP, x16
    //     0xf0f7d8: b.ls            #0xf0f8d8
    // 0xf0f7dc: ldr             x0, [fp, #0x10]
    // 0xf0f7e0: r2 = LoadInt32Instr(r0)
    //     0xf0f7e0: sbfx            x2, x0, #1, #0x1f
    //     0xf0f7e4: tbz             w0, #0, #0xf0f7ec
    //     0xf0f7e8: ldur            x2, [x0, #7]
    // 0xf0f7ec: add             x3, x2, #1
    // 0xf0f7f0: LoadField: r4 = r1->field_f
    //     0xf0f7f0: ldur            w4, [x1, #0xf]
    // 0xf0f7f4: DecompressPointer r4
    //     0xf0f7f4: add             x4, x4, HEAP, lsl #32
    // 0xf0f7f8: LoadField: r1 = r4->field_7
    //     0xf0f7f8: ldur            w1, [x4, #7]
    // 0xf0f7fc: r5 = LoadInt32Instr(r1)
    //     0xf0f7fc: sbfx            x5, x1, #1, #0x1f
    // 0xf0f800: cmp             x3, x5
    // 0xf0f804: b.le            #0xf0f878
    // 0xf0f808: r0 = LoadStaticField(0x804)
    //     0xf0f808: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0f80c: ldr             x0, [x0, #0x1008]
    // 0xf0f810: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0f814: cmp             w0, w16
    // 0xf0f818: b.ne            #0xf0f824
    // 0xf0f81c: r2 = rsbt
    //     0xf0f81c: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0f820: r0 = InitLateFinalStaticField()
    //     0xf0f820: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0f824: LoadField: r3 = r0->field_1f
    //     0xf0f824: ldur            w3, [x0, #0x1f]
    // 0xf0f828: DecompressPointer r3
    //     0xf0f828: add             x3, x3, HEAP, lsl #32
    // 0xf0f82c: stur            x3, [fp, #-8]
    // 0xf0f830: r1 = Null
    //     0xf0f830: mov             x1, NULL
    // 0xf0f834: r2 = 4
    //     0xf0f834: movz            x2, #0x4
    // 0xf0f838: r0 = AllocateArray()
    //     0xf0f838: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0f83c: r16 = "按键数据长度不足，索引越界: "
    //     0xf0f83c: add             x16, PP, #0x12, lsl #12  ; [pp+0x12568] "按键数据长度不足，索引越界: "
    //     0xf0f840: ldr             x16, [x16, #0x568]
    // 0xf0f844: StoreField: r0->field_f = r16
    //     0xf0f844: stur            w16, [x0, #0xf]
    // 0xf0f848: ldr             x1, [fp, #0x10]
    // 0xf0f84c: StoreField: r0->field_13 = r1
    //     0xf0f84c: stur            w1, [x0, #0x13]
    // 0xf0f850: str             x0, [SP]
    // 0xf0f854: r0 = _interpolate()
    //     0xf0f854: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0f858: ldur            x1, [fp, #-8]
    // 0xf0f85c: mov             x2, x0
    // 0xf0f860: r4 = const [0, 0x2, 0, 0x2, null]
    //     0xf0f860: ldr             x4, [PP, #0x5b0]  ; [pp+0x5b0] List(5) [0, 0x2, 0, 0x2, Null]
    // 0xf0f864: r0 = w()
    //     0xf0f864: bl              #0x6bf3f0  ; [package:logger/src/logger.dart] Logger::w
    // 0xf0f868: r0 = -2
    //     0xf0f868: orr             x0, xzr, #0xfffffffffffffffe
    // 0xf0f86c: LeaveFrame
    //     0xf0f86c: mov             SP, fp
    //     0xf0f870: ldp             fp, lr, [SP], #0x10
    // 0xf0f874: ret
    //     0xf0f874: ret             
    // 0xf0f878: r0 = BoxInt64Instr(r3)
    //     0xf0f878: sbfiz           x0, x3, #1, #0x1f
    //     0xf0f87c: cmp             x3, x0, asr #1
    //     0xf0f880: b.eq            #0xf0f88c
    //     0xf0f884: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xf0f888: stur            x3, [x0, #7]
    // 0xf0f88c: str             x0, [SP]
    // 0xf0f890: mov             x1, x4
    // 0xf0f894: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0f894: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0f898: r0 = substring()
    //     0xf0f898: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0f89c: r16 = 32
    //     0xf0f89c: movz            x16, #0x20
    // 0xf0f8a0: str             x16, [SP]
    // 0xf0f8a4: mov             x1, x0
    // 0xf0f8a8: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf0f8a8: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf0f8ac: ldr             x4, [x4, #0x128]
    // 0xf0f8b0: r0 = parse()
    //     0xf0f8b0: bl              #0x621868  ; [dart:core] int::parse
    // 0xf0f8b4: mov             x2, x0
    // 0xf0f8b8: r0 = BoxInt64Instr(r2)
    //     0xf0f8b8: sbfiz           x0, x2, #1, #0x1f
    //     0xf0f8bc: cmp             x2, x0, asr #1
    //     0xf0f8c0: b.eq            #0xf0f8cc
    //     0xf0f8c4: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xf0f8c8: stur            x2, [x0, #7]
    // 0xf0f8cc: LeaveFrame
    //     0xf0f8cc: mov             SP, fp
    //     0xf0f8d0: ldp             fp, lr, [SP], #0x10
    // 0xf0f8d4: ret
    //     0xf0f8d4: ret             
    // 0xf0f8d8: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0f8d8: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0f8dc: b               #0xf0f7dc
  }
  _ _handleGainLevel(/* No info */) {
    // ** addr: 0xf0f8e0, size: 0x124
    // 0xf0f8e0: EnterFrame
    //     0xf0f8e0: stp             fp, lr, [SP, #-0x10]!
    //     0xf0f8e4: mov             fp, SP
    // 0xf0f8e8: AllocStack(0x20)
    //     0xf0f8e8: sub             SP, SP, #0x20
    // 0xf0f8ec: SetupParameters(ZTReceiver this /* r1 => r2, fp-0x8 */, dynamic _ /* r2 => r0, fp-0x10 */)
    //     0xf0f8ec: mov             x0, x2
    //     0xf0f8f0: stur            x2, [fp, #-0x10]
    //     0xf0f8f4: mov             x2, x1
    //     0xf0f8f8: stur            x1, [fp, #-8]
    // 0xf0f8fc: CheckStackOverflow
    //     0xf0f8fc: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0f900: cmp             SP, x16
    //     0xf0f904: b.ls            #0xf0f9f0
    // 0xf0f908: r16 = 32
    //     0xf0f908: movz            x16, #0x20
    // 0xf0f90c: str             x16, [SP]
    // 0xf0f910: mov             x1, x0
    // 0xf0f914: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf0f914: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf0f918: ldr             x4, [x4, #0x128]
    // 0xf0f91c: r0 = parse()
    //     0xf0f91c: bl              #0x621868  ; [dart:core] int::parse
    // 0xf0f920: cmp             x0, #1
    // 0xf0f924: b.lt            #0xf0f930
    // 0xf0f928: cmp             x0, #3
    // 0xf0f92c: b.le            #0xf0f9a4
    // 0xf0f930: ldur            x0, [fp, #-0x10]
    // 0xf0f934: r0 = LoadStaticField(0x804)
    //     0xf0f934: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0f938: ldr             x0, [x0, #0x1008]
    // 0xf0f93c: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0f940: cmp             w0, w16
    // 0xf0f944: b.ne            #0xf0f950
    // 0xf0f948: r2 = rsbt
    //     0xf0f948: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0f94c: r0 = InitLateFinalStaticField()
    //     0xf0f94c: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0f950: LoadField: r3 = r0->field_1f
    //     0xf0f950: ldur            w3, [x0, #0x1f]
    // 0xf0f954: DecompressPointer r3
    //     0xf0f954: add             x3, x3, HEAP, lsl #32
    // 0xf0f958: stur            x3, [fp, #-0x18]
    // 0xf0f95c: r1 = Null
    //     0xf0f95c: mov             x1, NULL
    // 0xf0f960: r2 = 4
    //     0xf0f960: movz            x2, #0x4
    // 0xf0f964: r0 = AllocateArray()
    //     0xf0f964: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0f968: r16 = "增益等级数据超出处理范围 "
    //     0xf0f968: add             x16, PP, #0x12, lsl #12  ; [pp+0x12570] "增益等级数据超出处理范围 "
    //     0xf0f96c: ldr             x16, [x16, #0x570]
    // 0xf0f970: StoreField: r0->field_f = r16
    //     0xf0f970: stur            w16, [x0, #0xf]
    // 0xf0f974: ldur            x1, [fp, #-0x10]
    // 0xf0f978: StoreField: r0->field_13 = r1
    //     0xf0f978: stur            w1, [x0, #0x13]
    // 0xf0f97c: str             x0, [SP]
    // 0xf0f980: r0 = _interpolate()
    //     0xf0f980: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0f984: ldur            x1, [fp, #-0x18]
    // 0xf0f988: mov             x2, x0
    // 0xf0f98c: r4 = const [0, 0x2, 0, 0x2, null]
    //     0xf0f98c: ldr             x4, [PP, #0x5b0]  ; [pp+0x5b0] List(5) [0, 0x2, 0, 0x2, Null]
    // 0xf0f990: r0 = w()
    //     0xf0f990: bl              #0x6bf3f0  ; [package:logger/src/logger.dart] Logger::w
    // 0xf0f994: r0 = Null
    //     0xf0f994: mov             x0, NULL
    // 0xf0f998: LeaveFrame
    //     0xf0f998: mov             SP, fp
    //     0xf0f99c: ldp             fp, lr, [SP], #0x10
    // 0xf0f9a0: ret
    //     0xf0f9a0: ret             
    // 0xf0f9a4: ldur            x1, [fp, #-8]
    // 0xf0f9a8: LoadField: r2 = r1->field_7
    //     0xf0f9a8: ldur            w2, [x1, #7]
    // 0xf0f9ac: DecompressPointer r2
    //     0xf0f9ac: add             x2, x2, HEAP, lsl #32
    // 0xf0f9b0: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0f9b4: cmp             w2, w16
    // 0xf0f9b8: b.eq            #0xf0f9f8
    // 0xf0f9bc: sub             x1, x0, #1
    // 0xf0f9c0: r0 = LoadClassIdInstr(r2)
    //     0xf0f9c0: ldur            x0, [x2, #-1]
    //     0xf0f9c4: ubfx            x0, x0, #0xc, #0x14
    // 0xf0f9c8: mov             x16, x1
    // 0xf0f9cc: mov             x1, x2
    // 0xf0f9d0: mov             x2, x16
    // 0xf0f9d4: r0 = GDT[cid_x0 + -0xa37]()
    //     0xf0f9d4: sub             lr, x0, #0xa37
    //     0xf0f9d8: ldr             lr, [x21, lr, lsl #3]
    //     0xf0f9dc: blr             lr
    // 0xf0f9e0: r0 = Null
    //     0xf0f9e0: mov             x0, NULL
    // 0xf0f9e4: LeaveFrame
    //     0xf0f9e4: mov             SP, fp
    //     0xf0f9e8: ldp             fp, lr, [SP], #0x10
    // 0xf0f9ec: ret
    //     0xf0f9ec: ret             
    // 0xf0f9f0: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0f9f0: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0f9f4: b               #0xf0f908
    // 0xf0f9f8: r9 = receiveHandler
    //     0xf0f9f8: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf0f9fc: ldr             x9, [x9, #0x4a8]
    // 0xf0fa00: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf0fa00: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleCustomEqData(/* No info */) {
    // ** addr: 0xf0fa04, size: 0xe4
    // 0xf0fa04: EnterFrame
    //     0xf0fa04: stp             fp, lr, [SP, #-0x10]!
    //     0xf0fa08: mov             fp, SP
    // 0xf0fa0c: AllocStack(0x28)
    //     0xf0fa0c: sub             SP, SP, #0x28
    // 0xf0fa10: SetupParameters(ZTReceiver this /* r1 => r2, fp-0x8 */, dynamic _ /* r2 => r0, fp-0x10 */)
    //     0xf0fa10: mov             x0, x2
    //     0xf0fa14: stur            x2, [fp, #-0x10]
    //     0xf0fa18: mov             x2, x1
    //     0xf0fa1c: stur            x1, [fp, #-8]
    // 0xf0fa20: CheckStackOverflow
    //     0xf0fa20: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0fa24: cmp             SP, x16
    //     0xf0fa28: b.ls            #0xf0fad4
    // 0xf0fa2c: mov             x1, x0
    // 0xf0fa30: r0 = fromFormat()
    //     0xf0fa30: bl              #0xbb95a4  ; [package:roselink_bluetooth/commander/receiver/r_receive_handler.dart] EqData::fromFormat
    // 0xf0fa34: stur            x0, [fp, #-0x18]
    // 0xf0fa38: r0 = LoadStaticField(0x804)
    //     0xf0fa38: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0fa3c: ldr             x0, [x0, #0x1008]
    // 0xf0fa40: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0fa44: cmp             w0, w16
    // 0xf0fa48: b.ne            #0xf0fa54
    // 0xf0fa4c: r2 = rsbt
    //     0xf0fa4c: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0fa50: r0 = InitLateFinalStaticField()
    //     0xf0fa50: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0fa54: LoadField: r3 = r0->field_1f
    //     0xf0fa54: ldur            w3, [x0, #0x1f]
    // 0xf0fa58: DecompressPointer r3
    //     0xf0fa58: add             x3, x3, HEAP, lsl #32
    // 0xf0fa5c: stur            x3, [fp, #-0x20]
    // 0xf0fa60: r1 = Null
    //     0xf0fa60: mov             x1, NULL
    // 0xf0fa64: r2 = 4
    //     0xf0fa64: movz            x2, #0x4
    // 0xf0fa68: r0 = AllocateArray()
    //     0xf0fa68: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0fa6c: r16 = "自定义EQ数据获取到了 "
    //     0xf0fa6c: add             x16, PP, #0x12, lsl #12  ; [pp+0x12578] "自定义EQ数据获取到了 "
    //     0xf0fa70: ldr             x16, [x16, #0x578]
    // 0xf0fa74: StoreField: r0->field_f = r16
    //     0xf0fa74: stur            w16, [x0, #0xf]
    // 0xf0fa78: ldur            x1, [fp, #-0x10]
    // 0xf0fa7c: StoreField: r0->field_13 = r1
    //     0xf0fa7c: stur            w1, [x0, #0x13]
    // 0xf0fa80: str             x0, [SP]
    // 0xf0fa84: r0 = _interpolate()
    //     0xf0fa84: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0fa88: ldur            x1, [fp, #-0x20]
    // 0xf0fa8c: mov             x2, x0
    // 0xf0fa90: r0 = i()
    //     0xf0fa90: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xf0fa94: ldur            x0, [fp, #-8]
    // 0xf0fa98: LoadField: r1 = r0->field_7
    //     0xf0fa98: ldur            w1, [x0, #7]
    // 0xf0fa9c: DecompressPointer r1
    //     0xf0fa9c: add             x1, x1, HEAP, lsl #32
    // 0xf0faa0: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0faa4: cmp             w1, w16
    // 0xf0faa8: b.eq            #0xf0fadc
    // 0xf0faac: r0 = LoadClassIdInstr(r1)
    //     0xf0faac: ldur            x0, [x1, #-1]
    //     0xf0fab0: ubfx            x0, x0, #0xc, #0x14
    // 0xf0fab4: ldur            x2, [fp, #-0x18]
    // 0xf0fab8: r0 = GDT[cid_x0 + -0x9cf]()
    //     0xf0fab8: sub             lr, x0, #0x9cf
    //     0xf0fabc: ldr             lr, [x21, lr, lsl #3]
    //     0xf0fac0: blr             lr
    // 0xf0fac4: r0 = Null
    //     0xf0fac4: mov             x0, NULL
    // 0xf0fac8: LeaveFrame
    //     0xf0fac8: mov             SP, fp
    //     0xf0facc: ldp             fp, lr, [SP], #0x10
    // 0xf0fad0: ret
    //     0xf0fad0: ret             
    // 0xf0fad4: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0fad4: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0fad8: b               #0xf0fa2c
    // 0xf0fadc: r9 = receiveHandler
    //     0xf0fadc: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf0fae0: ldr             x9, [x9, #0x4a8]
    // 0xf0fae4: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf0fae4: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleEQData(/* No info */) {
    // ** addr: 0xf0fae8, size: 0x104
    // 0xf0fae8: EnterFrame
    //     0xf0fae8: stp             fp, lr, [SP, #-0x10]!
    //     0xf0faec: mov             fp, SP
    // 0xf0faf0: AllocStack(0x20)
    //     0xf0faf0: sub             SP, SP, #0x20
    // 0xf0faf4: SetupParameters(ZTReceiver this /* r1 => r0, fp-0x8 */, dynamic _ /* r2 => r1, fp-0x10 */)
    //     0xf0faf4: mov             x0, x1
    //     0xf0faf8: stur            x1, [fp, #-8]
    //     0xf0fafc: mov             x1, x2
    //     0xf0fb00: stur            x2, [fp, #-0x10]
    // 0xf0fb04: CheckStackOverflow
    //     0xf0fb04: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0fb08: cmp             SP, x16
    //     0xf0fb0c: b.ls            #0xf0fbd8
    // 0xf0fb10: r0 = LoadStaticField(0x804)
    //     0xf0fb10: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0fb14: ldr             x0, [x0, #0x1008]
    // 0xf0fb18: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0fb1c: cmp             w0, w16
    // 0xf0fb20: b.ne            #0xf0fb2c
    // 0xf0fb24: r2 = rsbt
    //     0xf0fb24: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0fb28: r0 = InitLateFinalStaticField()
    //     0xf0fb28: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0fb2c: LoadField: r3 = r0->field_1f
    //     0xf0fb2c: ldur            w3, [x0, #0x1f]
    // 0xf0fb30: DecompressPointer r3
    //     0xf0fb30: add             x3, x3, HEAP, lsl #32
    // 0xf0fb34: stur            x3, [fp, #-0x18]
    // 0xf0fb38: r1 = Null
    //     0xf0fb38: mov             x1, NULL
    // 0xf0fb3c: r2 = 4
    //     0xf0fb3c: movz            x2, #0x4
    // 0xf0fb40: r0 = AllocateArray()
    //     0xf0fb40: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0fb44: r16 = "eq数据获取到了 "
    //     0xf0fb44: add             x16, PP, #0x12, lsl #12  ; [pp+0x12580] "eq数据获取到了 "
    //     0xf0fb48: ldr             x16, [x16, #0x580]
    // 0xf0fb4c: StoreField: r0->field_f = r16
    //     0xf0fb4c: stur            w16, [x0, #0xf]
    // 0xf0fb50: ldur            x1, [fp, #-0x10]
    // 0xf0fb54: StoreField: r0->field_13 = r1
    //     0xf0fb54: stur            w1, [x0, #0x13]
    // 0xf0fb58: str             x0, [SP]
    // 0xf0fb5c: r0 = _interpolate()
    //     0xf0fb5c: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0fb60: ldur            x1, [fp, #-0x18]
    // 0xf0fb64: mov             x2, x0
    // 0xf0fb68: r0 = i()
    //     0xf0fb68: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xf0fb6c: ldur            x0, [fp, #-8]
    // 0xf0fb70: LoadField: r2 = r0->field_7
    //     0xf0fb70: ldur            w2, [x0, #7]
    // 0xf0fb74: DecompressPointer r2
    //     0xf0fb74: add             x2, x2, HEAP, lsl #32
    // 0xf0fb78: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0fb7c: cmp             w2, w16
    // 0xf0fb80: b.eq            #0xf0fbe0
    // 0xf0fb84: stur            x2, [fp, #-0x18]
    // 0xf0fb88: r16 = 32
    //     0xf0fb88: movz            x16, #0x20
    // 0xf0fb8c: str             x16, [SP]
    // 0xf0fb90: ldur            x1, [fp, #-0x10]
    // 0xf0fb94: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf0fb94: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf0fb98: ldr             x4, [x4, #0x128]
    // 0xf0fb9c: r0 = parse()
    //     0xf0fb9c: bl              #0x621868  ; [dart:core] int::parse
    // 0xf0fba0: ldur            x1, [fp, #-0x18]
    // 0xf0fba4: r2 = LoadClassIdInstr(r1)
    //     0xf0fba4: ldur            x2, [x1, #-1]
    //     0xf0fba8: ubfx            x2, x2, #0xc, #0x14
    // 0xf0fbac: mov             x16, x0
    // 0xf0fbb0: mov             x0, x2
    // 0xf0fbb4: mov             x2, x16
    // 0xf0fbb8: ldur            x3, [fp, #-0x10]
    // 0xf0fbbc: r0 = GDT[cid_x0 + -0xf6f]()
    //     0xf0fbbc: sub             lr, x0, #0xf6f
    //     0xf0fbc0: ldr             lr, [x21, lr, lsl #3]
    //     0xf0fbc4: blr             lr
    // 0xf0fbc8: r0 = Null
    //     0xf0fbc8: mov             x0, NULL
    // 0xf0fbcc: LeaveFrame
    //     0xf0fbcc: mov             SP, fp
    //     0xf0fbd0: ldp             fp, lr, [SP], #0x10
    // 0xf0fbd4: ret
    //     0xf0fbd4: ret             
    // 0xf0fbd8: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0fbd8: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0fbdc: b               #0xf0fb10
    // 0xf0fbe0: r9 = receiveHandler
    //     0xf0fbe0: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf0fbe4: ldr             x9, [x9, #0x4a8]
    // 0xf0fbe8: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf0fbe8: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleFirmwareVersion(/* No info */) {
    // ** addr: 0xf0fbec, size: 0x228
    // 0xf0fbec: EnterFrame
    //     0xf0fbec: stp             fp, lr, [SP, #-0x10]!
    //     0xf0fbf0: mov             fp, SP
    // 0xf0fbf4: AllocStack(0x48)
    //     0xf0fbf4: sub             SP, SP, #0x48
    // 0xf0fbf8: SetupParameters(ZTReceiver this /* r1 => r3, fp-0x8 */, dynamic _ /* r2 => r0, fp-0x10 */)
    //     0xf0fbf8: mov             x3, x1
    //     0xf0fbfc: mov             x0, x2
    //     0xf0fc00: stur            x1, [fp, #-8]
    //     0xf0fc04: stur            x2, [fp, #-0x10]
    // 0xf0fc08: CheckStackOverflow
    //     0xf0fc08: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0fc0c: cmp             SP, x16
    //     0xf0fc10: b.ls            #0xf0fe00
    // 0xf0fc14: r16 = 2
    //     0xf0fc14: movz            x16, #0x2
    // 0xf0fc18: str             x16, [SP]
    // 0xf0fc1c: mov             x1, x0
    // 0xf0fc20: r2 = 0
    //     0xf0fc20: movz            x2, #0
    // 0xf0fc24: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0fc24: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0fc28: r0 = substring()
    //     0xf0fc28: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0fc2c: r16 = 32
    //     0xf0fc2c: movz            x16, #0x20
    // 0xf0fc30: str             x16, [SP]
    // 0xf0fc34: mov             x1, x0
    // 0xf0fc38: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf0fc38: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf0fc3c: ldr             x4, [x4, #0x128]
    // 0xf0fc40: r0 = parse()
    //     0xf0fc40: bl              #0x621868  ; [dart:core] int::parse
    // 0xf0fc44: stur            x0, [fp, #-0x18]
    // 0xf0fc48: r16 = 6
    //     0xf0fc48: movz            x16, #0x6
    // 0xf0fc4c: str             x16, [SP]
    // 0xf0fc50: ldur            x1, [fp, #-0x10]
    // 0xf0fc54: r2 = 2
    //     0xf0fc54: movz            x2, #0x2
    // 0xf0fc58: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0fc58: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0fc5c: r0 = substring()
    //     0xf0fc5c: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0fc60: r16 = 32
    //     0xf0fc60: movz            x16, #0x20
    // 0xf0fc64: str             x16, [SP]
    // 0xf0fc68: mov             x1, x0
    // 0xf0fc6c: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf0fc6c: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf0fc70: ldr             x4, [x4, #0x128]
    // 0xf0fc74: r0 = parse()
    //     0xf0fc74: bl              #0x621868  ; [dart:core] int::parse
    // 0xf0fc78: stur            x0, [fp, #-0x20]
    // 0xf0fc7c: r16 = 10
    //     0xf0fc7c: movz            x16, #0xa
    // 0xf0fc80: str             x16, [SP]
    // 0xf0fc84: ldur            x1, [fp, #-0x10]
    // 0xf0fc88: r2 = 4
    //     0xf0fc88: movz            x2, #0x4
    // 0xf0fc8c: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0fc8c: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0fc90: r0 = substring()
    //     0xf0fc90: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0fc94: r16 = 32
    //     0xf0fc94: movz            x16, #0x20
    // 0xf0fc98: str             x16, [SP]
    // 0xf0fc9c: mov             x1, x0
    // 0xf0fca0: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf0fca0: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf0fca4: ldr             x4, [x4, #0x128]
    // 0xf0fca8: r0 = parse()
    //     0xf0fca8: bl              #0x621868  ; [dart:core] int::parse
    // 0xf0fcac: stur            x0, [fp, #-0x28]
    // 0xf0fcb0: r0 = LoadStaticField(0x804)
    //     0xf0fcb0: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0fcb4: ldr             x0, [x0, #0x1008]
    // 0xf0fcb8: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0fcbc: cmp             w0, w16
    // 0xf0fcc0: b.ne            #0xf0fccc
    // 0xf0fcc4: r2 = rsbt
    //     0xf0fcc4: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0fcc8: r0 = InitLateFinalStaticField()
    //     0xf0fcc8: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0fccc: LoadField: r3 = r0->field_1f
    //     0xf0fccc: ldur            w3, [x0, #0x1f]
    // 0xf0fcd0: DecompressPointer r3
    //     0xf0fcd0: add             x3, x3, HEAP, lsl #32
    // 0xf0fcd4: stur            x3, [fp, #-0x10]
    // 0xf0fcd8: r1 = Null
    //     0xf0fcd8: mov             x1, NULL
    // 0xf0fcdc: r2 = 12
    //     0xf0fcdc: movz            x2, #0xc
    // 0xf0fce0: r0 = AllocateArray()
    //     0xf0fce0: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0fce4: mov             x2, x0
    // 0xf0fce8: r16 = "固件版本数据 "
    //     0xf0fce8: add             x16, PP, #0x12, lsl #12  ; [pp+0x12588] "固件版本数据 "
    //     0xf0fcec: ldr             x16, [x16, #0x588]
    // 0xf0fcf0: StoreField: r2->field_f = r16
    //     0xf0fcf0: stur            w16, [x2, #0xf]
    // 0xf0fcf4: ldur            x3, [fp, #-0x18]
    // 0xf0fcf8: r0 = BoxInt64Instr(r3)
    //     0xf0fcf8: sbfiz           x0, x3, #1, #0x1f
    //     0xf0fcfc: cmp             x3, x0, asr #1
    //     0xf0fd00: b.eq            #0xf0fd0c
    //     0xf0fd04: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xf0fd08: stur            x3, [x0, #7]
    // 0xf0fd0c: mov             x3, x0
    // 0xf0fd10: stur            x3, [fp, #-0x40]
    // 0xf0fd14: StoreField: r2->field_13 = r3
    //     0xf0fd14: stur            w3, [x2, #0x13]
    // 0xf0fd18: r16 = " "
    //     0xf0fd18: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xf0fd1c: ArrayStore: r2[0] = r16  ; List_4
    //     0xf0fd1c: stur            w16, [x2, #0x17]
    // 0xf0fd20: ldur            x4, [fp, #-0x20]
    // 0xf0fd24: r0 = BoxInt64Instr(r4)
    //     0xf0fd24: sbfiz           x0, x4, #1, #0x1f
    //     0xf0fd28: cmp             x4, x0, asr #1
    //     0xf0fd2c: b.eq            #0xf0fd38
    //     0xf0fd30: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xf0fd34: stur            x4, [x0, #7]
    // 0xf0fd38: mov             x4, x0
    // 0xf0fd3c: stur            x4, [fp, #-0x38]
    // 0xf0fd40: StoreField: r2->field_1b = r4
    //     0xf0fd40: stur            w4, [x2, #0x1b]
    // 0xf0fd44: r16 = " "
    //     0xf0fd44: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xf0fd48: StoreField: r2->field_1f = r16
    //     0xf0fd48: stur            w16, [x2, #0x1f]
    // 0xf0fd4c: ldur            x5, [fp, #-0x28]
    // 0xf0fd50: r0 = BoxInt64Instr(r5)
    //     0xf0fd50: sbfiz           x0, x5, #1, #0x1f
    //     0xf0fd54: cmp             x5, x0, asr #1
    //     0xf0fd58: b.eq            #0xf0fd64
    //     0xf0fd5c: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xf0fd60: stur            x5, [x0, #7]
    // 0xf0fd64: stur            x0, [fp, #-0x30]
    // 0xf0fd68: StoreField: r2->field_23 = r0
    //     0xf0fd68: stur            w0, [x2, #0x23]
    // 0xf0fd6c: str             x2, [SP]
    // 0xf0fd70: r0 = _interpolate()
    //     0xf0fd70: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0fd74: ldur            x1, [fp, #-0x10]
    // 0xf0fd78: mov             x2, x0
    // 0xf0fd7c: r0 = i()
    //     0xf0fd7c: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xf0fd80: ldur            x0, [fp, #-8]
    // 0xf0fd84: LoadField: r3 = r0->field_7
    //     0xf0fd84: ldur            w3, [x0, #7]
    // 0xf0fd88: DecompressPointer r3
    //     0xf0fd88: add             x3, x3, HEAP, lsl #32
    // 0xf0fd8c: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0fd90: cmp             w3, w16
    // 0xf0fd94: b.eq            #0xf0fe08
    // 0xf0fd98: stur            x3, [fp, #-0x10]
    // 0xf0fd9c: r1 = Null
    //     0xf0fd9c: mov             x1, NULL
    // 0xf0fda0: r2 = 6
    //     0xf0fda0: movz            x2, #0x6
    // 0xf0fda4: r0 = AllocateArray()
    //     0xf0fda4: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0fda8: mov             x1, x0
    // 0xf0fdac: ldur            x0, [fp, #-0x40]
    // 0xf0fdb0: StoreField: r1->field_f = r0
    //     0xf0fdb0: stur            w0, [x1, #0xf]
    // 0xf0fdb4: ldur            x0, [fp, #-0x38]
    // 0xf0fdb8: StoreField: r1->field_13 = r0
    //     0xf0fdb8: stur            w0, [x1, #0x13]
    // 0xf0fdbc: ldur            x0, [fp, #-0x30]
    // 0xf0fdc0: ArrayStore: r1[0] = r0  ; List_4
    //     0xf0fdc0: stur            w0, [x1, #0x17]
    // 0xf0fdc4: str             x1, [SP]
    // 0xf0fdc8: r0 = _interpolate()
    //     0xf0fdc8: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0fdcc: ldur            x1, [fp, #-0x10]
    // 0xf0fdd0: r2 = LoadClassIdInstr(r1)
    //     0xf0fdd0: ldur            x2, [x1, #-1]
    //     0xf0fdd4: ubfx            x2, x2, #0xc, #0x14
    // 0xf0fdd8: mov             x16, x0
    // 0xf0fddc: mov             x0, x2
    // 0xf0fde0: mov             x2, x16
    // 0xf0fde4: r0 = GDT[cid_x0 + -0xb98]()
    //     0xf0fde4: sub             lr, x0, #0xb98
    //     0xf0fde8: ldr             lr, [x21, lr, lsl #3]
    //     0xf0fdec: blr             lr
    // 0xf0fdf0: r0 = Null
    //     0xf0fdf0: mov             x0, NULL
    // 0xf0fdf4: LeaveFrame
    //     0xf0fdf4: mov             SP, fp
    //     0xf0fdf8: ldp             fp, lr, [SP], #0x10
    // 0xf0fdfc: ret
    //     0xf0fdfc: ret             
    // 0xf0fe00: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0fe00: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0fe04: b               #0xf0fc14
    // 0xf0fe08: r9 = receiveHandler
    //     0xf0fe08: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf0fe0c: ldr             x9, [x9, #0x4a8]
    // 0xf0fe10: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf0fe10: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleHeadfreeBatteryData(/* No info */) {
    // ** addr: 0xf0fe14, size: 0x154
    // 0xf0fe14: EnterFrame
    //     0xf0fe14: stp             fp, lr, [SP, #-0x10]!
    //     0xf0fe18: mov             fp, SP
    // 0xf0fe1c: AllocStack(0x28)
    //     0xf0fe1c: sub             SP, SP, #0x28
    // 0xf0fe20: SetupParameters(ZTReceiver this /* r1 => r3, fp-0x8 */, dynamic _ /* r2 => r0, fp-0x10 */)
    //     0xf0fe20: mov             x3, x1
    //     0xf0fe24: mov             x0, x2
    //     0xf0fe28: stur            x1, [fp, #-8]
    //     0xf0fe2c: stur            x2, [fp, #-0x10]
    // 0xf0fe30: CheckStackOverflow
    //     0xf0fe30: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0fe34: cmp             SP, x16
    //     0xf0fe38: b.ls            #0xf0ff54
    // 0xf0fe3c: r16 = 40
    //     0xf0fe3c: movz            x16, #0x28
    // 0xf0fe40: str             x16, [SP]
    // 0xf0fe44: mov             x1, x0
    // 0xf0fe48: r2 = 18
    //     0xf0fe48: movz            x2, #0x12
    // 0xf0fe4c: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0fe4c: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0fe50: r0 = substring()
    //     0xf0fe50: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0fe54: stur            x0, [fp, #-0x18]
    // 0xf0fe58: r16 = 32
    //     0xf0fe58: movz            x16, #0x20
    // 0xf0fe5c: str             x16, [SP]
    // 0xf0fe60: mov             x1, x0
    // 0xf0fe64: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf0fe64: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf0fe68: ldr             x4, [x4, #0x128]
    // 0xf0fe6c: r0 = parse()
    //     0xf0fe6c: bl              #0x621868  ; [dart:core] int::parse
    // 0xf0fe70: stur            x0, [fp, #-0x20]
    // 0xf0fe74: r0 = RBatteryData()
    //     0xf0fe74: bl              #0xefbe0c  ; AllocateRBatteryDataStub -> RBatteryData (size=0x2c)
    // 0xf0fe78: mov             x1, x0
    // 0xf0fe7c: r0 = 255
    //     0xf0fe7c: movz            x0, #0xff
    // 0xf0fe80: StoreField: r1->field_7 = r0
    //     0xf0fe80: stur            x0, [x1, #7]
    // 0xf0fe84: StoreField: r1->field_f = r0
    //     0xf0fe84: stur            x0, [x1, #0xf]
    // 0xf0fe88: ldur            x0, [fp, #-0x20]
    // 0xf0fe8c: ArrayStore: r1[0] = r0  ; List_8
    //     0xf0fe8c: stur            x0, [x1, #0x17]
    // 0xf0fe90: r0 = true
    //     0xf0fe90: add             x0, NULL, #0x20  ; true
    // 0xf0fe94: StoreField: r1->field_1f = r0
    //     0xf0fe94: stur            w0, [x1, #0x1f]
    // 0xf0fe98: StoreField: r1->field_23 = r0
    //     0xf0fe98: stur            w0, [x1, #0x23]
    // 0xf0fe9c: r0 = false
    //     0xf0fe9c: add             x0, NULL, #0x30  ; false
    // 0xf0fea0: StoreField: r1->field_27 = r0
    //     0xf0fea0: stur            w0, [x1, #0x27]
    // 0xf0fea4: ldur            x0, [fp, #-8]
    // 0xf0fea8: LoadField: r2 = r0->field_7
    //     0xf0fea8: ldur            w2, [x0, #7]
    // 0xf0feac: DecompressPointer r2
    //     0xf0feac: add             x2, x2, HEAP, lsl #32
    // 0xf0feb0: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0feb4: cmp             w2, w16
    // 0xf0feb8: b.eq            #0xf0ff5c
    // 0xf0febc: r0 = LoadClassIdInstr(r2)
    //     0xf0febc: ldur            x0, [x2, #-1]
    //     0xf0fec0: ubfx            x0, x0, #0xc, #0x14
    // 0xf0fec4: mov             x16, x1
    // 0xf0fec8: mov             x1, x2
    // 0xf0fecc: mov             x2, x16
    // 0xf0fed0: ldur            x3, [fp, #-0x10]
    // 0xf0fed4: r0 = GDT[cid_x0 + -0xf7d]()
    //     0xf0fed4: sub             lr, x0, #0xf7d
    //     0xf0fed8: ldr             lr, [x21, lr, lsl #3]
    //     0xf0fedc: blr             lr
    // 0xf0fee0: r0 = LoadStaticField(0x804)
    //     0xf0fee0: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf0fee4: ldr             x0, [x0, #0x1008]
    // 0xf0fee8: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf0feec: cmp             w0, w16
    // 0xf0fef0: b.ne            #0xf0fefc
    // 0xf0fef4: r2 = rsbt
    //     0xf0fef4: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf0fef8: r0 = InitLateFinalStaticField()
    //     0xf0fef8: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf0fefc: LoadField: r3 = r0->field_1f
    //     0xf0fefc: ldur            w3, [x0, #0x1f]
    // 0xf0ff00: DecompressPointer r3
    //     0xf0ff00: add             x3, x3, HEAP, lsl #32
    // 0xf0ff04: stur            x3, [fp, #-8]
    // 0xf0ff08: r1 = Null
    //     0xf0ff08: mov             x1, NULL
    // 0xf0ff0c: r2 = 6
    //     0xf0ff0c: movz            x2, #0x6
    // 0xf0ff10: r0 = AllocateArray()
    //     0xf0ff10: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf0ff14: r16 = "[电量] 充电仓电量 "
    //     0xf0ff14: add             x16, PP, #0x12, lsl #12  ; [pp+0x12590] "[电量] 充电仓电量 "
    //     0xf0ff18: ldr             x16, [x16, #0x590]
    // 0xf0ff1c: StoreField: r0->field_f = r16
    //     0xf0ff1c: stur            w16, [x0, #0xf]
    // 0xf0ff20: ldur            x1, [fp, #-0x18]
    // 0xf0ff24: StoreField: r0->field_13 = r1
    //     0xf0ff24: stur            w1, [x0, #0x13]
    // 0xf0ff28: r16 = " "
    //     0xf0ff28: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xf0ff2c: ArrayStore: r0[0] = r16  ; List_4
    //     0xf0ff2c: stur            w16, [x0, #0x17]
    // 0xf0ff30: str             x0, [SP]
    // 0xf0ff34: r0 = _interpolate()
    //     0xf0ff34: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf0ff38: ldur            x1, [fp, #-8]
    // 0xf0ff3c: mov             x2, x0
    // 0xf0ff40: r0 = t()
    //     0xf0ff40: bl              #0x798af0  ; [package:logger/src/logger.dart] Logger::t
    // 0xf0ff44: r0 = Null
    //     0xf0ff44: mov             x0, NULL
    // 0xf0ff48: LeaveFrame
    //     0xf0ff48: mov             SP, fp
    //     0xf0ff4c: ldp             fp, lr, [SP], #0x10
    // 0xf0ff50: ret
    //     0xf0ff50: ret             
    // 0xf0ff54: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf0ff54: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf0ff58: b               #0xf0fe3c
    // 0xf0ff5c: r9 = receiveHandler
    //     0xf0ff5c: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf0ff60: ldr             x9, [x9, #0x4a8]
    // 0xf0ff64: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf0ff64: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleBatteryData(/* No info */) {
    // ** addr: 0xf0ff68, size: 0x2b0
    // 0xf0ff68: EnterFrame
    //     0xf0ff68: stp             fp, lr, [SP, #-0x10]!
    //     0xf0ff6c: mov             fp, SP
    // 0xf0ff70: AllocStack(0x60)
    //     0xf0ff70: sub             SP, SP, #0x60
    // 0xf0ff74: SetupParameters(ZTReceiver this /* r1 => r3, fp-0x8 */, dynamic _ /* r2 => r0, fp-0x10 */)
    //     0xf0ff74: mov             x3, x1
    //     0xf0ff78: mov             x0, x2
    //     0xf0ff7c: stur            x1, [fp, #-8]
    //     0xf0ff80: stur            x2, [fp, #-0x10]
    // 0xf0ff84: CheckStackOverflow
    //     0xf0ff84: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf0ff88: cmp             SP, x16
    //     0xf0ff8c: b.ls            #0xf10204
    // 0xf0ff90: r16 = 48
    //     0xf0ff90: movz            x16, #0x30
    // 0xf0ff94: str             x16, [SP]
    // 0xf0ff98: mov             x1, x0
    // 0xf0ff9c: r2 = 22
    //     0xf0ff9c: movz            x2, #0x16
    // 0xf0ffa0: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0ffa0: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0ffa4: r0 = substring()
    //     0xf0ffa4: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0ffa8: stur            x0, [fp, #-0x18]
    // 0xf0ffac: r16 = 52
    //     0xf0ffac: movz            x16, #0x34
    // 0xf0ffb0: str             x16, [SP]
    // 0xf0ffb4: ldur            x1, [fp, #-0x10]
    // 0xf0ffb8: r2 = 24
    //     0xf0ffb8: movz            x2, #0x18
    // 0xf0ffbc: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0ffbc: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0ffc0: r0 = substring()
    //     0xf0ffc0: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0ffc4: stur            x0, [fp, #-0x20]
    // 0xf0ffc8: r16 = 64
    //     0xf0ffc8: movz            x16, #0x40
    // 0xf0ffcc: str             x16, [SP]
    // 0xf0ffd0: ldur            x1, [fp, #-0x10]
    // 0xf0ffd4: r2 = 30
    //     0xf0ffd4: movz            x2, #0x1e
    // 0xf0ffd8: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0ffd8: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0ffdc: r0 = substring()
    //     0xf0ffdc: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0ffe0: stur            x0, [fp, #-0x28]
    // 0xf0ffe4: r16 = 56
    //     0xf0ffe4: movz            x16, #0x38
    // 0xf0ffe8: str             x16, [SP]
    // 0xf0ffec: ldur            x1, [fp, #-0x10]
    // 0xf0fff0: r2 = 26
    //     0xf0fff0: movz            x2, #0x1a
    // 0xf0fff4: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf0fff4: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf0fff8: r0 = substring()
    //     0xf0fff8: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf0fffc: r1 = LoadClassIdInstr(r0)
    //     0xf0fffc: ldur            x1, [x0, #-1]
    //     0xf10000: ubfx            x1, x1, #0xc, #0x14
    // 0xf10004: r16 = "00"
    //     0xf10004: ldr             x16, [PP, #0x7578]  ; [pp+0x7578] "00"
    // 0xf10008: stp             x16, x0, [SP]
    // 0xf1000c: mov             x0, x1
    // 0xf10010: mov             lr, x0
    // 0xf10014: ldr             lr, [x21, lr, lsl #3]
    // 0xf10018: blr             lr
    // 0xf1001c: eor             x3, x0, #0x10
    // 0xf10020: stur            x3, [fp, #-0x30]
    // 0xf10024: r16 = 60
    //     0xf10024: movz            x16, #0x3c
    // 0xf10028: str             x16, [SP]
    // 0xf1002c: ldur            x1, [fp, #-0x10]
    // 0xf10030: r2 = 28
    //     0xf10030: movz            x2, #0x1c
    // 0xf10034: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xf10034: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xf10038: r0 = substring()
    //     0xf10038: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xf1003c: r1 = LoadClassIdInstr(r0)
    //     0xf1003c: ldur            x1, [x0, #-1]
    //     0xf10040: ubfx            x1, x1, #0xc, #0x14
    // 0xf10044: r16 = "00"
    //     0xf10044: ldr             x16, [PP, #0x7578]  ; [pp+0x7578] "00"
    // 0xf10048: stp             x16, x0, [SP]
    // 0xf1004c: mov             x0, x1
    // 0xf10050: mov             lr, x0
    // 0xf10054: ldr             lr, [x21, lr, lsl #3]
    // 0xf10058: blr             lr
    // 0xf1005c: eor             x2, x0, #0x10
    // 0xf10060: stur            x2, [fp, #-0x38]
    // 0xf10064: r16 = 32
    //     0xf10064: movz            x16, #0x20
    // 0xf10068: str             x16, [SP]
    // 0xf1006c: ldur            x1, [fp, #-0x18]
    // 0xf10070: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf10070: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf10074: ldr             x4, [x4, #0x128]
    // 0xf10078: r0 = parse()
    //     0xf10078: bl              #0x621868  ; [dart:core] int::parse
    // 0xf1007c: stur            x0, [fp, #-0x40]
    // 0xf10080: r16 = 32
    //     0xf10080: movz            x16, #0x20
    // 0xf10084: str             x16, [SP]
    // 0xf10088: ldur            x1, [fp, #-0x20]
    // 0xf1008c: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf1008c: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf10090: ldr             x4, [x4, #0x128]
    // 0xf10094: r0 = parse()
    //     0xf10094: bl              #0x621868  ; [dart:core] int::parse
    // 0xf10098: stur            x0, [fp, #-0x48]
    // 0xf1009c: r16 = 32
    //     0xf1009c: movz            x16, #0x20
    // 0xf100a0: str             x16, [SP]
    // 0xf100a4: ldur            x1, [fp, #-0x28]
    // 0xf100a8: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xf100a8: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xf100ac: ldr             x4, [x4, #0x128]
    // 0xf100b0: r0 = parse()
    //     0xf100b0: bl              #0x621868  ; [dart:core] int::parse
    // 0xf100b4: stur            x0, [fp, #-0x50]
    // 0xf100b8: r0 = RBatteryData()
    //     0xf100b8: bl              #0xefbe0c  ; AllocateRBatteryDataStub -> RBatteryData (size=0x2c)
    // 0xf100bc: mov             x1, x0
    // 0xf100c0: ldur            x0, [fp, #-0x40]
    // 0xf100c4: StoreField: r1->field_7 = r0
    //     0xf100c4: stur            x0, [x1, #7]
    // 0xf100c8: ldur            x0, [fp, #-0x48]
    // 0xf100cc: StoreField: r1->field_f = r0
    //     0xf100cc: stur            x0, [x1, #0xf]
    // 0xf100d0: ldur            x0, [fp, #-0x50]
    // 0xf100d4: ArrayStore: r1[0] = r0  ; List_8
    //     0xf100d4: stur            x0, [x1, #0x17]
    // 0xf100d8: ldur            x4, [fp, #-0x30]
    // 0xf100dc: StoreField: r1->field_1f = r4
    //     0xf100dc: stur            w4, [x1, #0x1f]
    // 0xf100e0: ldur            x5, [fp, #-0x38]
    // 0xf100e4: StoreField: r1->field_23 = r5
    //     0xf100e4: stur            w5, [x1, #0x23]
    // 0xf100e8: r0 = false
    //     0xf100e8: add             x0, NULL, #0x30  ; false
    // 0xf100ec: StoreField: r1->field_27 = r0
    //     0xf100ec: stur            w0, [x1, #0x27]
    // 0xf100f0: ldur            x0, [fp, #-8]
    // 0xf100f4: LoadField: r2 = r0->field_7
    //     0xf100f4: ldur            w2, [x0, #7]
    // 0xf100f8: DecompressPointer r2
    //     0xf100f8: add             x2, x2, HEAP, lsl #32
    // 0xf100fc: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf10100: cmp             w2, w16
    // 0xf10104: b.eq            #0xf1020c
    // 0xf10108: r0 = LoadClassIdInstr(r2)
    //     0xf10108: ldur            x0, [x2, #-1]
    //     0xf1010c: ubfx            x0, x0, #0xc, #0x14
    // 0xf10110: mov             x16, x1
    // 0xf10114: mov             x1, x2
    // 0xf10118: mov             x2, x16
    // 0xf1011c: ldur            x3, [fp, #-0x10]
    // 0xf10120: r0 = GDT[cid_x0 + -0xf7d]()
    //     0xf10120: sub             lr, x0, #0xf7d
    //     0xf10124: ldr             lr, [x21, lr, lsl #3]
    //     0xf10128: blr             lr
    // 0xf1012c: r0 = LoadStaticField(0x804)
    //     0xf1012c: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xf10130: ldr             x0, [x0, #0x1008]
    // 0xf10134: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xf10138: cmp             w0, w16
    // 0xf1013c: b.ne            #0xf10148
    // 0xf10140: r2 = rsbt
    //     0xf10140: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xf10144: r0 = InitLateFinalStaticField()
    //     0xf10144: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xf10148: LoadField: r3 = r0->field_1f
    //     0xf10148: ldur            w3, [x0, #0x1f]
    // 0xf1014c: DecompressPointer r3
    //     0xf1014c: add             x3, x3, HEAP, lsl #32
    // 0xf10150: stur            x3, [fp, #-8]
    // 0xf10154: r1 = Null
    //     0xf10154: mov             x1, NULL
    // 0xf10158: r2 = 32
    //     0xf10158: movz            x2, #0x20
    // 0xf1015c: r0 = AllocateArray()
    //     0xf1015c: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf10160: r16 = "电量数据 原始数据 "
    //     0xf10160: add             x16, PP, #0x12, lsl #12  ; [pp+0x12598] "电量数据 原始数据 "
    //     0xf10164: ldr             x16, [x16, #0x598]
    // 0xf10168: StoreField: r0->field_f = r16
    //     0xf10168: stur            w16, [x0, #0xf]
    // 0xf1016c: ldur            x1, [fp, #-0x18]
    // 0xf10170: StoreField: r0->field_13 = r1
    //     0xf10170: stur            w1, [x0, #0x13]
    // 0xf10174: r16 = " "
    //     0xf10174: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xf10178: ArrayStore: r0[0] = r16  ; List_4
    //     0xf10178: stur            w16, [x0, #0x17]
    // 0xf1017c: ldur            x2, [fp, #-0x20]
    // 0xf10180: StoreField: r0->field_1b = r2
    //     0xf10180: stur            w2, [x0, #0x1b]
    // 0xf10184: r16 = " "
    //     0xf10184: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xf10188: StoreField: r0->field_1f = r16
    //     0xf10188: stur            w16, [x0, #0x1f]
    // 0xf1018c: ldur            x3, [fp, #-0x28]
    // 0xf10190: StoreField: r0->field_23 = r3
    //     0xf10190: stur            w3, [x0, #0x23]
    // 0xf10194: r16 = " 十六进制原始数据："
    //     0xf10194: add             x16, PP, #0x12, lsl #12  ; [pp+0x125a0] " 十六进制原始数据："
    //     0xf10198: ldr             x16, [x16, #0x5a0]
    // 0xf1019c: StoreField: r0->field_27 = r16
    //     0xf1019c: stur            w16, [x0, #0x27]
    // 0xf101a0: StoreField: r0->field_2b = r1
    //     0xf101a0: stur            w1, [x0, #0x2b]
    // 0xf101a4: r16 = " "
    //     0xf101a4: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xf101a8: StoreField: r0->field_2f = r16
    //     0xf101a8: stur            w16, [x0, #0x2f]
    // 0xf101ac: StoreField: r0->field_33 = r2
    //     0xf101ac: stur            w2, [x0, #0x33]
    // 0xf101b0: r16 = " "
    //     0xf101b0: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xf101b4: StoreField: r0->field_37 = r16
    //     0xf101b4: stur            w16, [x0, #0x37]
    // 0xf101b8: StoreField: r0->field_3b = r3
    //     0xf101b8: stur            w3, [x0, #0x3b]
    // 0xf101bc: r16 = "  人仓L/R "
    //     0xf101bc: add             x16, PP, #0x12, lsl #12  ; [pp+0x125a8] "  人仓L/R "
    //     0xf101c0: ldr             x16, [x16, #0x5a8]
    // 0xf101c4: StoreField: r0->field_3f = r16
    //     0xf101c4: stur            w16, [x0, #0x3f]
    // 0xf101c8: ldur            x1, [fp, #-0x30]
    // 0xf101cc: StoreField: r0->field_43 = r1
    //     0xf101cc: stur            w1, [x0, #0x43]
    // 0xf101d0: r16 = " "
    //     0xf101d0: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xf101d4: StoreField: r0->field_47 = r16
    //     0xf101d4: stur            w16, [x0, #0x47]
    // 0xf101d8: ldur            x1, [fp, #-0x38]
    // 0xf101dc: StoreField: r0->field_4b = r1
    //     0xf101dc: stur            w1, [x0, #0x4b]
    // 0xf101e0: str             x0, [SP]
    // 0xf101e4: r0 = _interpolate()
    //     0xf101e4: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf101e8: ldur            x1, [fp, #-8]
    // 0xf101ec: mov             x2, x0
    // 0xf101f0: r0 = t()
    //     0xf101f0: bl              #0x798af0  ; [package:logger/src/logger.dart] Logger::t
    // 0xf101f4: r0 = Null
    //     0xf101f4: mov             x0, NULL
    // 0xf101f8: LeaveFrame
    //     0xf101f8: mov             SP, fp
    //     0xf101fc: ldp             fp, lr, [SP], #0x10
    // 0xf10200: ret
    //     0xf10200: ret             
    // 0xf10204: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf10204: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf10208: b               #0xf0ff90
    // 0xf1020c: r9 = receiveHandler
    //     0xf1020c: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xf10210: ldr             x9, [x9, #0x4a8]
    // 0xf10214: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xf10214: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
}
