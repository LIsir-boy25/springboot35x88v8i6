




















































<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item class="input" v-if="type!='info'"  label="订单编号" prop="dingdanbianhao" >
					<el-input v-model="ruleForm.dingdanbianhao" placeholder="订单编号" clearable  :readonly="ro.dingdanbianhao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="订单编号" prop="dingdanbianhao" >
					<el-input v-model="ruleForm.dingdanbianhao" placeholder="订单编号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="区域" prop="quyu" >
					<el-input v-model="ruleForm.quyu" placeholder="区域" clearable  :readonly="ro.quyu"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="区域" prop="quyu" >
					<el-input v-model="ruleForm.quyu" placeholder="区域" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="货物类型" prop="huowuleixing" >
					<el-input v-model="ruleForm.huowuleixing" placeholder="货物类型" clearable  :readonly="ro.huowuleixing"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="货物类型" prop="huowuleixing" >
					<el-input v-model="ruleForm.huowuleixing" placeholder="货物类型" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="重量(kg)" prop="zhongliang" >
					<el-input v-model="ruleForm.zhongliang" placeholder="重量(kg)" clearable  :readonly="ro.zhongliang"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="重量(kg)" prop="zhongliang" >
					<el-input v-model="ruleForm.zhongliang" placeholder="重量(kg)" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="体积(m³)" prop="tiji" >
					<el-input v-model="ruleForm.tiji" placeholder="体积(m³)" clearable  :readonly="ro.tiji"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="体积(m³)" prop="tiji" >
					<el-input v-model="ruleForm.tiji" placeholder="体积(m³)" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.huowutupian" label="货物图片" prop="huowutupian" >
					<file-upload
						tip="点击上传货物图片"
						action="file/upload"
						:limit="3"
						:disabled="ro.huowutupian"
						:multiple="true"
						:fileUrls="ruleForm.huowutupian?ruleForm.huowutupian:''"
						@change="huowutupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.huowutupian" label="货物图片" prop="huowutupian" >
					<img v-if="ruleForm.huowutupian.substring(0,4)=='http'&&ruleForm.huowutupian.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.huowutupian" width="100" height="100" @click="imgPreView(ruleForm.tupian)">
					<img v-else-if="ruleForm.huowutupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.huowutupian.split(',')[0]" width="100" height="100" @click="imgPreView(ruleForm.tupian.split(',')[0])">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.huowutupian.split(',')" :src="$base.url+item" width="100" height="100" @click="imgPreView($base.url+item)">
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="装货地址" prop="zhuanghuodizhi" >
					<el-input v-model="ruleForm.zhuanghuodizhi" placeholder="装货地址" clearable  :readonly="ro.zhuanghuodizhi"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="装货地址" prop="zhuanghuodizhi" >
					<el-input v-model="ruleForm.zhuanghuodizhi" placeholder="装货地址" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="送货地址" prop="songhuodizhi" >
					<el-input v-model="ruleForm.songhuodizhi" placeholder="送货地址" clearable  :readonly="ro.songhuodizhi"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="送货地址" prop="songhuodizhi" >
					<el-input v-model="ruleForm.songhuodizhi" placeholder="送货地址" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="期望装货时间" prop="qiwangzhuanghuoshijian" >
					<el-input v-model="ruleForm.qiwangzhuanghuoshijian" placeholder="期望装货时间" clearable  :readonly="ro.qiwangzhuanghuoshijian"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="期望装货时间" prop="qiwangzhuanghuoshijian" >
					<el-input v-model="ruleForm.qiwangzhuanghuoshijian" placeholder="期望装货时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="是否需要回单" prop="shifouxuyaohuidan" >
					<el-input v-model="ruleForm.shifouxuyaohuidan" placeholder="是否需要回单" clearable  :readonly="ro.shifouxuyaohuidan"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="是否需要回单" prop="shifouxuyaohuidan" >
					<el-input v-model="ruleForm.shifouxuyaohuidan" placeholder="是否需要回单" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="里程" prop="licheng" >
					<el-input-number v-model="ruleForm.licheng" placeholder="里程" :disabled="ro.licheng"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="里程" prop="licheng" >
					<el-input v-model="ruleForm.licheng" placeholder="里程" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="车型" prop="chexing" >
					<el-input v-model="ruleForm.chexing" placeholder="车型" clearable  :readonly="ro.chexing"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="车型" prop="chexing" >
					<el-input v-model="ruleForm.chexing" placeholder="车型" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="每公里价格(元)" prop="jiage" >
					<el-input-number v-model="ruleForm.jiage" placeholder="每公里价格(元)" :disabled="ro.jiage"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="每公里价格(元)" prop="jiage" >
					<el-input v-model="ruleForm.jiage" placeholder="每公里价格(元)" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="运费" prop="yue" >
					<el-input-number v-model="ruleForm.yue" placeholder="运费" :disabled="ro.yue"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="运费" prop="yue" >
					<el-input v-model="ruleForm.yue" placeholder="运费" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="异常类型" prop="yichangleixing" >
					<el-select :disabled="ro.yichangleixing" v-model="ruleForm.yichangleixing" placeholder="请选择异常类型"  filterable>
						<el-option
							v-for="(item,index) in yichangleixingOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="异常类型" prop="yichangleixing" >
					<el-input v-model="ruleForm.yichangleixing"
						placeholder="异常类型" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="异常反馈" prop="yichangfankui" >
					<el-input v-model="ruleForm.yichangfankui" placeholder="异常反馈" clearable  :readonly="ro.yichangfankui"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="异常反馈" prop="yichangfankui" >
					<el-input v-model="ruleForm.yichangfankui" placeholder="异常反馈" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="反馈时间" prop="fankuishijian" >
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.fankuishijian" 
						type="datetime"
						:readonly="ro.fankuishijian"
						placeholder="反馈时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.fankuishijian" label="反馈时间" prop="fankuishijian" >
					<el-input v-model="ruleForm.fankuishijian" placeholder="反馈时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="处理状态" prop="chulizhuangtai" >
					<el-select :disabled="ro.chulizhuangtai" v-model="ruleForm.chulizhuangtai" placeholder="请选择处理状态"  filterable>
						<el-option
							v-for="(item,index) in chulizhuangtaiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="处理状态" prop="chulizhuangtai" >
					<el-input v-model="ruleForm.chulizhuangtai"
						placeholder="处理状态" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="货主账号" prop="huozhuzhanghao" >
					<el-input v-model="ruleForm.huozhuzhanghao" placeholder="货主账号" clearable  :readonly="ro.huozhuzhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="货主账号" prop="huozhuzhanghao" >
					<el-input v-model="ruleForm.huozhuzhanghao" placeholder="货主账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="货主姓名" prop="huozhuxingming" >
					<el-input v-model="ruleForm.huozhuxingming" placeholder="货主姓名" clearable  :readonly="ro.huozhuxingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="货主姓名" prop="huozhuxingming" >
					<el-input v-model="ruleForm.huozhuxingming" placeholder="货主姓名" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="联系方式" prop="lianxifangshi" >
					<el-input v-model="ruleForm.lianxifangshi" placeholder="联系方式" clearable  :readonly="ro.lianxifangshi"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="联系方式" prop="lianxifangshi" >
					<el-input v-model="ruleForm.lianxifangshi" placeholder="联系方式" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="司机账号" prop="sijizhanghao" >
					<el-input v-model="ruleForm.sijizhanghao" placeholder="司机账号" clearable  :readonly="ro.sijizhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="司机账号" prop="sijizhanghao" >
					<el-input v-model="ruleForm.sijizhanghao" placeholder="司机账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="司机姓名" prop="sijixingming" >
					<el-input v-model="ruleForm.sijixingming" placeholder="司机姓名" clearable  :readonly="ro.sijixingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="司机姓名" prop="sijixingming" >
					<el-input v-model="ruleForm.sijixingming" placeholder="司机姓名" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="车牌" prop="chepai" >
					<el-input v-model="ruleForm.chepai" placeholder="车牌" clearable  :readonly="ro.chepai"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="车牌" prop="chepai" >
					<el-input v-model="ruleForm.chepai" placeholder="车牌" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="车厢尺寸" prop="chexiangchicun" >
					<el-input v-model="ruleForm.chexiangchicun" placeholder="车厢尺寸" clearable  :readonly="ro.chexiangchicun"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="车厢尺寸" prop="chexiangchicun" >
					<el-input v-model="ruleForm.chexiangchicun" placeholder="车厢尺寸" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="手机号" prop="shoujihao" >
					<el-input v-model="ruleForm.shoujihao" placeholder="手机号" clearable  :readonly="ro.shoujihao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="手机号" prop="shoujihao" >
					<el-input v-model="ruleForm.shoujihao" placeholder="手机号" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-queren15"></span>
					确定 
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-guanbi2"></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-fanhui13"></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

	</div>
</template>
<script>
	import { 
		isNumber,
		isMobile,
	} from "@/utils/validate";
	export default {
		data() {
			var validateMobile = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isMobile(value)) {
					callback(new Error("请输入正确的手机号码"));
				} else {
					callback();
				}
			};
			var validateNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isNumber(value)) {
					callback(new Error("请输入数字"));
				} else {
					callback();
				}
			};
			return {
				id: '',
				type: '',
			
			
				ro:{
					dingdanbianhao : false,
					quyu : false,
					huowuleixing : false,
					zhongliang : false,
					tiji : false,
					huowutupian : false,
					zhuanghuodizhi : false,
					songhuodizhi : false,
					qiwangzhuanghuoshijian : false,
					shifouxuyaohuidan : false,
					licheng : false,
					chexing : false,
					jiage : false,
					yue : false,
					yichangleixing : false,
					yichangfankui : false,
					fankuishijian : false,
					chulizhuangtai : false,
					huozhuzhanghao : false,
					huozhuxingming : false,
					lianxifangshi : false,
					sijizhanghao : false,
					sijixingming : false,
					chepai : false,
					chexiangchicun : false,
					shoujihao : false,
				},
			
				ruleForm: {
					dingdanbianhao: '',
					quyu: '',
					huowuleixing: '',
					zhongliang: '',
					tiji: '',
					huowutupian: '',
					zhuanghuodizhi: '',
					songhuodizhi: '',
					qiwangzhuanghuoshijian: '',
					shifouxuyaohuidan: '',
					licheng: '',
					chexing: '',
					jiage: '',
					yue: '',
					yichangleixing: '',
					yichangfankui: '',
					fankuishijian: '',
					chulizhuangtai: '未处理',
					huozhuzhanghao: '',
					huozhuxingming: '',
					lianxifangshi: '',
					sijizhanghao: '',
					sijixingming: '',
					chepai: '',
					chexiangchicun: '',
					shoujihao: '',
				},
				yichangleixingOptions: [],
				chulizhuangtaiOptions: [],

				rules: {
					dingdanbianhao: [
					],
					quyu: [
					],
					huowuleixing: [
					],
					zhongliang: [
					],
					tiji: [
					],
					huowutupian: [
					],
					zhuanghuodizhi: [
					],
					songhuodizhi: [
					],
					qiwangzhuanghuoshijian: [
					],
					shifouxuyaohuidan: [
					],
					licheng: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					chexing: [
					],
					jiage: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					yue: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					yichangleixing: [
					],
					yichangfankui: [
					],
					fankuishijian: [
					],
					chulizhuangtai: [
					],
					huozhuzhanghao: [
					],
					huozhuxingming: [
					],
					lianxifangshi: [
						{ validator: validateMobile, trigger: 'blur' },
					],
					sijizhanghao: [
					],
					sijixingming: [
					],
					chepai: [
					],
					chexiangchicun: [
					],
					shoujihao: [
						{ validator: validateMobile, trigger: 'blur' },
					],
				},
			};
		},
		props: ["parent"],
		computed: {
			sessionForm() {
				return JSON.parse(this.$storage.getObj('userForm'))
			},
			sessionTable() {
				return this.$storage.get('sessionTable')
			},



		},
		components: {
		},
		created() {
			this.ruleForm.fankuishijian = this.getCurDateTime()
		},
		methods: {
			imgPreView(url){
				this.$parent.imgPreView(url)
			},
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(id,type ) {
				if (id) {
					this.id = id;
					this.type = type;
				}
				if(this.type=='info'||this.type=='else'||this.type=='msg'){
					this.info(id);
				}else if(this.type=='logistics'){
					for(let x in this.ro) {
						this.ro[x] = true
					}
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
						if(o=='dingdanbianhao'){
							this.ruleForm.dingdanbianhao = obj[o];
							this.ro.dingdanbianhao = true;
							continue;
						}
						if(o=='quyu'){
							this.ruleForm.quyu = obj[o];
							this.ro.quyu = true;
							continue;
						}
						if(o=='huowuleixing'){
							this.ruleForm.huowuleixing = obj[o];
							this.ro.huowuleixing = true;
							continue;
						}
						if(o=='zhongliang'){
							this.ruleForm.zhongliang = obj[o];
							this.ro.zhongliang = true;
							continue;
						}
						if(o=='tiji'){
							this.ruleForm.tiji = obj[o];
							this.ro.tiji = true;
							continue;
						}
						if(o=='huowutupian'){
							this.ruleForm.huowutupian = obj[o];
							this.ro.huowutupian = true;
							continue;
						}
						if(o=='zhuanghuodizhi'){
							this.ruleForm.zhuanghuodizhi = obj[o];
							this.ro.zhuanghuodizhi = true;
							continue;
						}
						if(o=='songhuodizhi'){
							this.ruleForm.songhuodizhi = obj[o];
							this.ro.songhuodizhi = true;
							continue;
						}
						if(o=='qiwangzhuanghuoshijian'){
							this.ruleForm.qiwangzhuanghuoshijian = obj[o];
							this.ro.qiwangzhuanghuoshijian = true;
							continue;
						}
						if(o=='shifouxuyaohuidan'){
							this.ruleForm.shifouxuyaohuidan = obj[o];
							this.ro.shifouxuyaohuidan = true;
							continue;
						}
						if(o=='licheng'){
							this.ruleForm.licheng = obj[o];
							this.ro.licheng = true;
							continue;
						}
						if(o=='chexing'){
							this.ruleForm.chexing = obj[o];
							this.ro.chexing = true;
							continue;
						}
						if(o=='jiage'){
							this.ruleForm.jiage = obj[o];
							this.ro.jiage = true;
							continue;
						}
						if(o=='yue'){
							this.ruleForm.yue = obj[o];
							this.ro.yue = true;
							continue;
						}
						if(o=='yichangleixing'){
							this.ruleForm.yichangleixing = obj[o];
							this.ro.yichangleixing = true;
							continue;
						}
						if(o=='yichangfankui'){
							this.ruleForm.yichangfankui = obj[o];
							this.ro.yichangfankui = true;
							continue;
						}
						if(o=='fankuishijian'){
							this.ruleForm.fankuishijian = obj[o];
							this.ro.fankuishijian = true;
							continue;
						}
						if(o=='chulizhuangtai'){
							this.ruleForm.chulizhuangtai = obj[o];
							this.ro.chulizhuangtai = true;
							continue;
						}
						if(o=='huozhuzhanghao'){
							this.ruleForm.huozhuzhanghao = obj[o];
							this.ro.huozhuzhanghao = true;
							continue;
						}
						if(o=='huozhuxingming'){
							this.ruleForm.huozhuxingming = obj[o];
							this.ro.huozhuxingming = true;
							continue;
						}
						if(o=='lianxifangshi'){
							this.ruleForm.lianxifangshi = obj[o];
							this.ro.lianxifangshi = true;
							continue;
						}
						if(o=='sijizhanghao'){
							this.ruleForm.sijizhanghao = obj[o];
							this.ro.sijizhanghao = true;
							continue;
						}
						if(o=='sijixingming'){
							this.ruleForm.sijixingming = obj[o];
							this.ro.sijixingming = true;
							continue;
						}
						if(o=='chepai'){
							this.ruleForm.chepai = obj[o];
							this.ro.chepai = true;
							continue;
						}
						if(o=='chexiangchicun'){
							this.ruleForm.chexiangchicun = obj[o];
							this.ro.chexiangchicun = true;
							continue;
						}
						if(o=='shoujihao'){
							this.ruleForm.shoujihao = obj[o];
							this.ro.shoujihao = true;
							continue;
						}
					}
					this.ruleForm.chulizhuangtai = '未处理'; 				}
				// 获取用户信息
				this.$http({
					url: `${this.sessionTable}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
						if(this.sessionTable!="users") {
							this.ro.chulizhuangtai = true;
						}
						if(((json.huozhuzhanghao!=''&&json.huozhuzhanghao) || json.huozhuzhanghao==0) && this.sessionTable!="users"){
							this.ruleForm.huozhuzhanghao = json.huozhuzhanghao
							this.ro.huozhuzhanghao = true;
						}
						if(((json.huozhuxingming!=''&&json.huozhuxingming) || json.huozhuxingming==0) && this.sessionTable!="users"){
							this.ruleForm.huozhuxingming = json.huozhuxingming
							this.ro.huozhuxingming = true;
						}
						if(((json.lianxifangshi!=''&&json.lianxifangshi) || json.lianxifangshi==0) && this.sessionTable!="users"){
							this.ruleForm.lianxifangshi = json.lianxifangshi
							this.ro.lianxifangshi = true;
						}
					} else {
						this.$message.error(data.msg);
					}
				});
				this.yichangleixingOptions = "装货延迟,地址错误,其它".split(',')
				this.chulizhuangtaiOptions = "已处理,未处理".split(',')
			
			},
			// 多级联动参数

			async info(id) {
				await this.$http({
					url: `yichangfankui/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					if(this.ruleForm.huowutupian!=null) {
						this.ruleForm.huowutupian = this.ruleForm.huowutupian.replace(new RegExp(this.$base.url,"g"),"");
					}
					var objcross = this.$storage.getObj('crossObj');
					if(!this.ruleForm.id) {
						delete this.ruleForm.userid
					}
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
									}
								}
							}
							await this.$http({
								url: `yichangfankui/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.yichangfankuiCrossAddOrUpdateFlag = false;
											this.parent.search();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});
						}
					});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.parent.showFlag = true;
				this.parent.addOrUpdateFlag = false;
				this.parent.yichangfankuiCrossAddOrUpdateFlag = false;
			},
			huowutupianUploadChange(fileUrls) {
				this.ruleForm.huowutupian = fileUrls;
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		padding: 30px;
	}
	.add-update-preview {
		border: 1px solid  #FFFFFF;
		border-radius: 32px;
		padding: 50px 30px;
		box-shadow: none;
		background: #f1f7fd;
		display: flex;
		flex-wrap: wrap;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview ::v-deep .el-form-item {
		margin: 10px 0px 10px 0 ;
		display: flex;
		width: 50%;
	}
	.add-update-preview .el-form-item ::v-deep .el-form-item__label {
		padding: 0 10px;
		color: #365E77;
		white-space: nowrap;
		font-weight: 400;
		width: 180px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item ::v-deep .el-form-item__content {
		margin-left: auto !important;
		margin: auto !important;
		align-content: flex-start;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
		height: 100%;
	}
	.add-update-preview ::v-deep .el-form-item.editorBox {
		margin: 10px 0px 10px 0 ;
		display: flex;
		width: 100%;
	}
	.add-update-preview .el-form-item.editorBox ::v-deep .el-form-item__label {
		padding: 0 10px;
		color: #000000;
		white-space: nowrap;
		font-weight: 500;
		display: block;
		width: 165px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item.editorBox ::v-deep .el-form-item__content {
		margin-left: auto !important;
		margin: auto !important;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
	}
	.add-update-preview ::v-deep.el-form-item.editorBox .editor {
		border: 0px solid #6579FE;
		border-radius: 8px;
		color: #6579FE;
		max-width: 100% !important;
		align-content: flex-start;
		background: none;
		display: flex;
		width: 100%;
		align-items: flex-start;
		flex-wrap: wrap;
		height: auto;
	}
	.add-update-preview ::v-deep.el-form-item.editorBox .editor .ql-toolbar {
		border: 1px solid #6579FE30;
		background: none;
		width: 100%;
		border-width: 1px 1px 0;
	}
	.add-update-preview ::v-deep.el-form-item.editorBox .editor .ql-container {
		border: 1px solid #6579FE30;
		background: none;
		width: 100%;
		min-height: 200px;
	}
	.add-update-preview ::v-deep.el-form-item.editorBox .editor .ql-container .ql-blank::before {
		color: #999;
	}
	
	.add-update-preview ::v-deep .el-form-item.textBox {
		margin: 10px 0px 10px 0 ;
		display: flex;
		width: 100%;
	}
	.add-update-preview .el-form-item.textBox ::v-deep .el-form-item__label {
		padding: 0 10px;
		color: #000000;
		white-space: nowrap;
		font-weight: 400;
		width: 165px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item.textBox ::v-deep .el-form-item__content {
		margin-left: auto !important;
		margin: auto !important;
		align-content: flex-start;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
		height: 100%;
	}
	.add-update-preview ::v-deep.el-form-item.textBox span.text {
		border: 1px solid #6579FE30;
		border-radius: 4px;
		padding: 12px 12px;
		outline: none;
		color: #6579FE;
		display: block;
		width: 100%;
		font-size: 16px;
		border-width: 0;
		height: auto;
	}
	
	.add-update-preview .el-input {
		width: 100%;
	}
	.add-update-preview .el-input ::v-deep .el-input__inner {
		border: 1px solid #6579FE30;
		border-radius: 4px;
		padding: 0 12px;
		outline: none;
		color: #6579FE;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 41px;
	}
	.add-update-preview .el-input ::v-deep .el-input__inner[readonly="readonly"] {
		border: 0px solid #ddd;
		border-radius: 4px;
		padding: 0 12px;
		outline: none;
		color: #666;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 41px;
	}
	.add-update-preview .el-input-number {
		text-align: left;
		width: 100%;
	}
	.add-update-preview .el-input-number ::v-deep .el-input__inner {
		text-align: left;
		border: 1px solid #6579FE30;
		border-radius: 4px;
		padding: 0 12px;
		outline: none;
		color: #6579FE;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 41px;
	}
	.add-update-preview .el-input-number ::v-deep .is-disabled .el-input__inner {
		text-align: left;
		border: 0px solid #ddd;
		border-radius: 4px;
		padding: 0 12px;
		outline: none;
		color: #666;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 41px;
	}
	.add-update-preview .el-input-number ::v-deep .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number ::v-deep .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: 100%;
	}
	.add-update-preview .el-select ::v-deep .el-input__inner {
		border: 1px solid #6579FE30;
		border-radius: 4px;
		padding: 0 12px;
		outline: none;
		color: #6579FE;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 41px;
	}
	.add-update-preview .el-select ::v-deep .is-disabled .el-input__inner {
		border: 0px solid #ddd;
		border-radius: 4px;
		padding: 0 12px;
		outline: none;
		color: #666;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 41px;
	}
	.add-update-preview .el-date-editor {
		width: 100%;
	}
	.add-update-preview .el-date-editor ::v-deep .el-input__inner {
		border: 1px solid #6579FE30;
		border-radius: 4px;
		padding: 0 30px;
		outline: none;
		color: #6579FE;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 41px;
	}
	.add-update-preview .el-date-editor ::v-deep .el-input__inner[readonly="readonly"] {
		border: 0px solid #ddd;
		border-radius: 4px;
		padding: 0 30px;
		outline: none;
		color: #666;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 41px;
	}
	.add-update-preview .viewBtn {
		border: 0px solid #555555;
		cursor: pointer;
		padding: 0 15px;
		margin: 0;
		color: #FFFFFF;
		font-weight: 600;
		font-size: 14px;
		line-height: 50px;
		border-radius: 8px;
		outline: none;
		background: #6579FE;
		width: 100%;
		text-align: center;
		height: 50px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 40px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 0px solid #555555;
		cursor: pointer;
		padding: 0 15px;
		margin: 0;
		color: #FFFFFF;
		font-weight: 600;
		font-size: 14px;
		line-height: 50px;
		border-radius: 8px;
		outline: none;
		background: #6579FE;
		width: 100%;
		text-align: center;
		height: 50px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 40px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 0px solid #555555;
		cursor: pointer;
		padding: 0 15px;
		margin: 0;
		color: #FFFFFF;
		font-weight: 600;
		font-size: 14px;
		line-height: 50px;
		border-radius: 8px;
		outline: none;
		background: #6579FE;
		width: 100%;
		text-align: center;
		height: 50px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 40px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview ::v-deep .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview ::v-deep .upload .upload-img {
		border: 1px solid #6579FE30;
		cursor: pointer;
		border-radius: 4px;
		color: #6579FE;
		background: none;
		font-weight: 600;
		width: 100px;
		font-size: 30px;
		line-height: 100px;
		text-align: center;
		height: 100px;
	}
	
	.add-update-preview ::v-deep .el-upload-list .el-upload-list__item {
		border: 1px solid #6579FE30;
		cursor: pointer;
		border-radius: 4px;
		color: #6579FE;
		background: none;
		font-weight: 600;
		width: 100px;
		font-size: 30px;
		line-height: 100px;
		text-align: center;
		height: 100px;
	}
	
	.add-update-preview ::v-deep .el-upload .el-icon-plus {
		border: 1px solid #6579FE30;
		cursor: pointer;
		border-radius: 4px;
		color: #6579FE;
		background: none;
		font-weight: 600;
		width: 100px;
		font-size: 30px;
		line-height: 100px;
		text-align: center;
		height: 100px;
	}
	.add-update-preview ::v-deep .el-upload__tip {
		padding: 0 10px;
		color: #365E77;
		font-size: 15px;
	}
	.add-update-preview ::v-deep .el-form-item.fileupload {
		margin: 10px 0px 10px 0 ;
		display: flex;
		width: calc(50% - 0px);
	}
	.add-update-preview .el-form-item.fileupload ::v-deep .el-form-item__label {
		padding: 0 10px;
		color: #365E77;
		white-space: nowrap;
		font-weight: 400;
		width: 180px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item.fileupload ::v-deep .el-form-item__content {
		margin-left: auto !important;
		margin: auto !important;
		align-content: flex-start;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
		height: 100%;
	}
	.add-update-preview .el-form-item.fileupload ::v-deep .el-upload-dragger {
		border: 1px solid #6579FE30;
		border-radius: 4px;
		outline: none;
		color: #333;
		background: none;
		display: flex;
		width: 100%;
		font-size: 16px;
		align-items: center;
		flex-wrap: wrap;
		height: 100px;
	}
	.add-update-preview .el-form-item.fileupload .el-upload-dragger ::v-deep .el-icon-upload {
		margin: 0;
		color: #206cb480;
		width: 100%;
		font-size: 66px;
	}
	.add-update-preview .el-form-item.fileupload .el-upload-dragger ::v-deep .el-upload__text {
		color: #606266;
		textalign: center;
		width: 100%;
		fontsize: 14px;
		line-height: 1;
	}
	.add-update-preview .el-form-item.fileupload .el-upload-dragger ::v-deep .el-upload__text em {
		fontstyle: normal;
		color: #409EFF;
	}
	
	.add-update-preview .el-textarea ::v-deep .el-textarea__inner {
		border: 1px solid #6579FE30;
		border-radius: 4px;
		padding: 12px;
		outline: none;
		color: #6579FE;
		background: none;
		width: 100%;
		font-size: 16px;
		height: auto;
	}
	.add-update-preview .el-textarea ::v-deep .el-textarea__inner[readonly="readonly"] {
		border: 0px solid #ddd;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 8px 12px 12px;
		outline: none;
		color: #666;
		background: none;
		width: 100%;
		font-size: 16px;
		height: auto;
	}
	.add-update-preview ::v-deep .el-form-item.btn {
		padding: 0 30px;
		margin: 30px  auto 0 auto;
		background: none;
		display: flex;
		width: auto;
		justify-content: center;
		flex-wrap: wrap;
		.btn1 {
			border: 0px solid #206cb4;
			cursor: pointer;
			padding: 0 24px;
			margin: 4px;
			color: #fff;
			font-weight: bold;
			font-size: 16px;
			border-radius: 24px;
			outline: none;
			background: #6579FE;
			width: auto;
			min-width: 176px;
			height: 47px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 16px;
				height: 40px;
			}
		}
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
			border: 0px solid #206cb4;
			cursor: pointer;
			padding: 0 24px;
			margin: 4px;
			color: #fff;
			font-weight: bold;
			font-size: 16px;
			border-radius: 24px;
			outline: none;
			background: #6579FE;
			width: auto;
			min-width: 176px;
			height: 47px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 16px;
				height: 40px;
			}
		}
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
			border: 0px solid #206cb4;
			cursor: pointer;
			padding: 0 24px;
			margin: 4px;
			color: #fff;
			font-weight: bold;
			font-size: 16px;
			border-radius: 24px;
			outline: none;
			background: #6579FE;
			width: auto;
			min-width: 176px;
			height: 47px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 16px;
				height: 40px;
			}
		}
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 0px solid #206cb4;
			cursor: pointer;
			padding: 0 24px;
			margin: 4px;
			color: #365E77;
			font-weight: bold;
			font-size: 16px;
			border-radius: 24px  24px  24px  24px;
			outline: none;
			background: #BED6FE;
			width: auto;
			min-width: 176px;
			height: 47px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 16px;
				height: 40px;
			}
		}
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 0px solid #206cb4;
			cursor: pointer;
			padding: 0 24px;
			margin: 4px;
			color: #365E77;
			font-weight: bold;
			font-size: 16px;
			border-radius: 24px  24px  24px  24px;
			outline: none;
			background: #BED6FE;
			width: auto;
			min-width: 176px;
			height: 47px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 16px;
				height: 40px;
			}
		}
		.btn5:hover {
			opacity: 0.8;
		}
	}
	.add-update-preview .el-form-item.btn ::v-deep .el-form-item__label {
		padding: 0 10px;
		color: #365E77;
		white-space: nowrap;
		font-weight: 400;
		width: 180px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item.btn ::v-deep .el-form-item__content {
		margin-left: auto !important;
		margin: auto !important;
		align-content: flex-start;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
		height: 100%;
	}
</style>
