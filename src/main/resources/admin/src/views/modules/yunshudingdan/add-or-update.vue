










































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
				<el-form-item class="input" v-if="type!='info'" label="订单编号" prop="dingdanbianhao" >
					<el-input v-model="ruleForm.dingdanbianhao" placeholder="订单编号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.dingdanbianhao" label="订单编号" prop="dingdanbianhao" >
					<el-input v-model="ruleForm.dingdanbianhao" placeholder="订单编号" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="区域" prop="quyu" >
					<el-select :disabled="ro.quyu" v-model="ruleForm.quyu" placeholder="请选择区域"  filterable>
						<el-option
							v-for="(item,index) in quyuOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="区域" prop="quyu" >
					<el-input v-model="ruleForm.quyu"
						placeholder="区域" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="货物类型" prop="huowuleixing" >
					<el-select :disabled="ro.huowuleixing" v-model="ruleForm.huowuleixing" placeholder="请选择货物类型"  filterable>
						<el-option
							v-for="(item,index) in huowuleixingOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="货物类型" prop="huowuleixing" >
					<el-input v-model="ruleForm.huowuleixing"
						placeholder="货物类型" readonly></el-input>
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
				<el-form-item class="input" v-if="type!='info'"  label="期望装货时间" prop="qiwangzhuanghuoshijian" >
					<el-input v-model="ruleForm.qiwangzhuanghuoshijian" placeholder="期望装货时间" clearable  :readonly="ro.qiwangzhuanghuoshijian"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="期望装货时间" prop="qiwangzhuanghuoshijian" >
					<el-input v-model="ruleForm.qiwangzhuanghuoshijian" placeholder="期望装货时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="是否需要回单" prop="shifouxuyaohuidan" >
					<el-select :disabled="ro.shifouxuyaohuidan" v-model="ruleForm.shifouxuyaohuidan" placeholder="请选择是否需要回单"  filterable>
						<el-option
							v-for="(item,index) in shifouxuyaohuidanOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="是否需要回单" prop="shifouxuyaohuidan" >
					<el-input v-model="ruleForm.shifouxuyaohuidan"
						placeholder="是否需要回单" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="里程" prop="licheng" >
					<el-input-number v-model="ruleForm.licheng" placeholder="里程" :disabled="ro.licheng"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="里程" prop="licheng" >
					<el-input v-model="ruleForm.licheng" placeholder="里程" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'" label="车型" prop="chexing" >
					<el-select :disabled="ro.chexing" @change="chexingChange" v-model="ruleForm.chexing" placeholder="请选择车型" filterable>
						<el-option
							v-for="(item,index) in chexingOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.chexing" label="车型" prop="chexing" >
					<el-input v-model="ruleForm.chexing" placeholder="车型" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="每公里价格(元)" prop="jiage" >
					<el-input-number v-model="ruleForm.jiage" placeholder="每公里价格(元)" :disabled="ro.jiage"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="每公里价格(元)" prop="jiage" >
					<el-input v-model="ruleForm.jiage" placeholder="每公里价格(元)" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'" label="运费" prop="yue" >
					<el-input v-model="yue" placeholder="运费" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.yue" label="运费" prop="yue" >
					<el-input v-model="ruleForm.yue" placeholder="运费" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="订单状态" prop="dingdanzhuangtai" >
					<el-select :disabled="ro.dingdanzhuangtai" v-model="ruleForm.dingdanzhuangtai" placeholder="请选择订单状态"  filterable>
						<el-option
							v-for="(item,index) in dingdanzhuangtaiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="订单状态" prop="dingdanzhuangtai" >
					<el-input v-model="ruleForm.dingdanzhuangtai"
						placeholder="订单状态" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="发布时间" prop="fabushijian" >
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.fabushijian" 
						type="datetime"
						:readonly="ro.fabushijian"
						placeholder="发布时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.fabushijian" label="发布时间" prop="fabushijian" >
					<el-input v-model="ruleForm.fabushijian" placeholder="发布时间" readonly></el-input>
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
			</template>
			<el-form-item class="input" v-if="type!='info'"  label="装货地址" prop="zhuanghuodizhi" >
				<el-input @click.native="openMapDiolag('zhuanghuodizhi')"  v-model="ruleForm.zhuanghuodizhi2" placeholder="请选择装货地址"></el-input>
			</el-form-item>
			<el-form-item class="input" v-else-if="ruleForm.zhuanghuodizhi" label="装货地址" prop="zhuanghuodizhi" >
				<el-input v-model="ruleForm.zhuanghuodizhi2" placeholder="请选择装货地址" readonly></el-input>
			</el-form-item>
			<el-form-item class="input" v-if="type!='info'"  label="送货地址" prop="songhuodizhi" >
				<el-input @click.native="openMapDiolag('songhuodizhi')"  v-model="ruleForm.songhuodizhi2" placeholder="请选择送货地址"></el-input>
			</el-form-item>
			<el-form-item class="input" v-else-if="ruleForm.songhuodizhi" label="送货地址" prop="songhuodizhi" >
				<el-input v-model="ruleForm.songhuodizhi2" placeholder="请选择送货地址" readonly></el-input>
			</el-form-item>
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
    
		<el-dialog
			width="50%"
			title="坐标查询"
			:visible.sync="mapVisiable"
			append-to-body>
			<el-amap-search-box class="search-box" :on-search-result="onSearchResult" :search-option="searchOption" ></el-amap-search-box>
			<div class="amap-wrapper">
				<el-amap class="amap-box" :vid="'amap-vue'" 
				:center="center"
				:zoom="zoom"
				:plugin="plugin"
				:events="events" >
				<el-amap-marker v-bind:key="marker" v-for="marker in markers" :position="marker" :events="events"></el-amap-marker>
				</el-amap>
			</div>
			<div>坐标：[{{ refColumn?(ruleForm[refColumn]?ruleForm[refColumn].split(';')[0]:''):ruleForm.longitude }}, {{ refColumn?(ruleForm[refColumn]?ruleForm[refColumn].split(';')[1]:''):ruleForm.latitude }}],地址：{{refColumn?ruleForm[refColumn + '2']:ruleForm.fulladdress}}</div>
		</el-dialog>

	</div>
</template>
<script>
	import { 
		isNumber,
		isIntNumer,
		isMobile,
	} from "@/utils/validate";
	import Vue from 'vue'
	import VueAMap from 'vue-amap'
	export default {
		data() {
			let self = this
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
			var validateIntNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isIntNumer(value)) {
					callback(new Error("请输入整数"));
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
					dingdanzhuangtai : false,
					fabushijian : false,
					huozhuzhanghao : false,
					huozhuxingming : false,
					lianxifangshi : false,
					clicktime : false,
					storeupnum : false,
				},
				refColumn: '',
				// 地图
				mapVisiable: false,
				zoom: 12,
				center: [116.410426, 39.934946],
				markers: [],
				searchOption: {
					citylimit: false
				},
				plugin: [{
					// 定位城市
					pName: "CitySearch",
					events: {
						init(o) {
							// o是高德地图定位插件实例
							o.getLocalCity(function(status, result) {
								if (status === "complete" && result.info === "OK") {
									// 查询成功，result即为当前所在城市信息
									self.center = [result.rectangle.split(';')[0].split(',')[0], result.rectangle.split(';')[0].split(',')[1]];
								}
							});
						}
					}
				}, ],
				events: {
					click (e) {
						let { lng, lat } = e.lnglat
						if(self.refColumn){
							
						}else {
							self.ruleForm.longitude = lng
							self.ruleForm.latitude = lat
						}
						
						// 这里通过高德 SDK 完成。
						/* eslint-disable */
						var geocoder = new AMap.Geocoder({
							radius: 1000,
							extensions: 'all'
						})
						geocoder.getAddress([lng, lat], function (status, result) {
							if (status === 'complete' && result.info === 'OK') {
								if (result && result.regeocode) {
									self.mapVisiable = false
									if(self.refColumn){
										self.ruleForm[self.refColumn] = lng + ';' + lat + ';' + result.regeocode.formattedAddress
										self.ruleForm[self.refColumn + '2'] = result.regeocode.formattedAddress
									}else {
										self.ruleForm.fulladdress = result.regeocode.formattedAddress
									}
									
								}
							}
						})
					}
				},
			
				ruleForm: {
					dingdanbianhao: this.getUUID(),
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
					dingdanzhuangtai: '未接单',
					fabushijian: '',
					huozhuzhanghao: '',
					huozhuxingming: '',
					lianxifangshi: '',
					clicktime: '',
				},
				quyuOptions: [],
				huowuleixingOptions: [],
				shifouxuyaohuidanOptions: [],
				chexingOptions: [],
				dingdanzhuangtaiOptions: [],

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
					dingdanzhuangtai: [
					],
					fabushijian: [
					],
					huozhuzhanghao: [
					],
					huozhuxingming: [
					],
					lianxifangshi: [
						{ validator: validateMobile, trigger: 'blur' },
					],
					clicktime: [
					],
					storeupnum: [
						{ validator: validateIntNumber, trigger: 'blur' },
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
			yue : {
				get: function () {
					let c = this.ruleForm
					let a = c.licheng*c.jiage
					this.ruleForm.yue = a?Number(Number(a).toFixed(2)):0
					return a?Number(Number(a).toFixed(2)):0
				}
			},



		},
		components: {
		},
		created() {
			this.ruleForm.fabushijian = this.getCurDateTime()
		},
		methods: {
			imgPreView(url){
				this.$parent.imgPreView(url)
			},
			// 打开坐标定位窗口
			async openMapDiolag (value=null) {
				if(window._AMapSecurityConfig==undefined) {
					await this.$http.get('config/info?name=gaode').then(rs=>{
						if(rs.data.data&&rs.data.data.value) {
							let res = JSON.parse(rs.data.data.value)
							window._AMapSecurityConfig = {
								securityJsCode: res.code,
							};
							VueAMap.initAMapApiLoader({
								key: res.key,
								plugin: ['AMap.Autocomplete', 'AMap.PlaceSearch', 'AMap.Scale', 'AMap.OverView', 'AMap.ToolBar', 'AMap.MapType', 'AMap.PolyEditor', 'AMap.CircleEditor', 'AMap.Geocoder','AMap.CitySearch'],
								// 默认高德 sdk 版本为 1.4.4
								v: '1.4.4'
							})
							Vue.use(VueAMap)
							this.$nextTick(()=>{
								if(value){
									this.refColumn = value
								}else{
									this.refColumn = ''
								}
								this.mapVisiable = true
							})
						}
						
					})
				}else {
					if(value){
						this.refColumn = value
					}else{
						this.refColumn = ''
					}
					this.mapVisiable = true
				}
			},
			// 查询
			onSearchResult (pois) {
				let latSum = 0;
				let lngSum = 0;
				if (pois.length > 0) {
					pois.forEach(poi => {
						let {lng, lat} = poi;
						lngSum += lng;
						latSum += lat;
						this.markers.push([poi.lng, poi.lat]);
					});
					let center = {
						lng: lngSum / pois.length,
						lat: latSum / pois.length
					};
					this.center = [center.lng, center.lat];
				}
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
							this.ruleForm.zhuanghuodizhi2 = obj[o].split(';')[2]
							this.ruleForm.zhuanghuodizhi = obj[o];
							this.ro.zhuanghuodizhi = true;
							continue;
						}
						if(o=='songhuodizhi'){
							this.ruleForm.songhuodizhi2 = obj[o].split(';')[2]
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
						if(o=='dingdanzhuangtai'){
							this.ruleForm.dingdanzhuangtai = obj[o];
							this.ro.dingdanzhuangtai = true;
							continue;
						}
						if(o=='fabushijian'){
							this.ruleForm.fabushijian = obj[o];
							this.ro.fabushijian = true;
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
						if(o=='clicktime'){
							this.ruleForm.clicktime = obj[o];
							this.ro.clicktime = true;
							continue;
						}
						if(o=='storeupnum'){
							this.ruleForm.storeupnum = obj[o];
							this.ro.storeupnum = true;
							continue;
						}
					}
					this.ruleForm.dingdanzhuangtai = '未接单'; 				}
				// 获取用户信息
				this.$http({
					url: `${this.sessionTable}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
						if(this.sessionTable!="users") {
							this.ro.dingdanzhuangtai = true;
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
				this.$http({
					url: `option/quyu/quyu`,
					method: "get",
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.quyuOptions = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
				this.$http({
					url: `option/huowuleixing/huowuleixing`,
					method: "get",
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.huowuleixingOptions = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
				this.shifouxuyaohuidanOptions = "是,否".split(',')
				this.$http({
					url: `option/chexing/chexing`,
					method: "get",
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.chexingOptions = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
				this.dingdanzhuangtaiOptions = "已接单,未接单".split(',')
			
			},
			// 下二随
			chexingChange () {
				this.$http({
					url: `follow/chexing/chexing?columnValue=`+ this.ruleForm.chexing,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						if(data.data.jiage){
							this.ruleForm.jiage = data.data.jiage
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			},
			// 多级联动参数

			async info(id) {
				await this.$http({
					url: `yunshudingdan/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
						this.ruleForm.zhuanghuodizhi2 = this.ruleForm.zhuanghuodizhi.split(';')[2]
						this.ruleForm.songhuodizhi2 = this.ruleForm.songhuodizhi.split(';')[2]
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					if(this.ruleForm.yue==0){
						this.$message.error('运费不能为空')
						return false
					}
					if(this.ruleForm.dingdanbianhao) {
						this.ruleForm.dingdanbianhao = String(this.ruleForm.dingdanbianhao)
					}
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
								url: `yunshudingdan/${!this.ruleForm.id ? "save" : "update"}`,
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
											this.parent.yunshudingdanCrossAddOrUpdateFlag = false;
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
				this.parent.yunshudingdanCrossAddOrUpdateFlag = false;
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
