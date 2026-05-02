






































<template>
	<div class="add-update-preview">
		<el-form
			class="add-update-form"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="200px"
			>
			<el-form-item class="add-item" label="订单编号" prop="dingdanbianhao">
				<el-input v-model="ruleForm.dingdanbianhao" 
					placeholder="订单编号" clearable :readonly="ro.dingdanbianhao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="区域" prop="quyu">
				<el-input v-model="ruleForm.quyu" 
					placeholder="区域" clearable :readonly="ro.quyu"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="货物类型" prop="huowuleixing">
				<el-input v-model="ruleForm.huowuleixing" 
					placeholder="货物类型" clearable :readonly="ro.huowuleixing"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="重量(kg)" prop="zhongliang">
				<el-input v-model="ruleForm.zhongliang" 
					placeholder="重量(kg)" clearable :readonly="ro.zhongliang"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="体积(m³)" prop="tiji">
				<el-input v-model="ruleForm.tiji" 
					placeholder="体积(m³)" clearable :readonly="ro.tiji"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="货物图片" v-if="type!='cross' || (type=='cross' && !ro.huowutupian)" prop="huowutupian">
				<file-upload
					tip="点击上传货物图片"
					action="file/upload"
					:limit="3"
					:multiple="true"
					:disabled="ro.huowutupian"
					:fileUrls="ruleForm.huowutupian?ruleForm.huowutupian:''"
					@change="huowutupianUploadChange"
					></file-upload>
			</el-form-item>
			<el-form-item class="add-item" v-else label="货物图片" prop="huowutupian">
				<img v-if="ruleForm.huowutupian.substring(0,4)=='http'" class="upload-img" v-bind:key="index" :src="ruleForm.huowutupian.split(',')[0]">
				<img v-else class="upload-img" v-bind:key="index" v-for="(item,index) in ruleForm.huowutupian.split(',')" :src="baseUrl+item">
			</el-form-item>
			<el-form-item class="add-item" label="装货地址" prop="zhuanghuodizhi">
				<el-input v-model="ruleForm.zhuanghuodizhi" 
					placeholder="装货地址" clearable :readonly="ro.zhuanghuodizhi"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="送货地址" prop="songhuodizhi">
				<el-input v-model="ruleForm.songhuodizhi" 
					placeholder="送货地址" clearable :readonly="ro.songhuodizhi"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="期望装货时间" prop="qiwangzhuanghuoshijian">
				<el-input v-model="ruleForm.qiwangzhuanghuoshijian" 
					placeholder="期望装货时间" clearable :readonly="ro.qiwangzhuanghuoshijian"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="是否需要回单" prop="shifouxuyaohuidan">
				<el-input v-model="ruleForm.shifouxuyaohuidan" 
					placeholder="是否需要回单" clearable :readonly="ro.shifouxuyaohuidan"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="里程" prop="licheng">
				<el-input-number v-model="ruleForm.licheng" placeholder="里程" :disabled="ro.licheng"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="车型" prop="chexing">
				<el-input v-model="ruleForm.chexing" 
					placeholder="车型" clearable :readonly="ro.chexing"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="每公里价格(元)" prop="jiage">
				<el-input-number v-model="ruleForm.jiage" placeholder="每公里价格(元)" :disabled="ro.jiage"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="运费" prop="yue">
				<el-input-number v-model="ruleForm.yue" placeholder="运费" :disabled="ro.yue"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="取消原因" prop="quxiaoyuanyin">
				<el-input v-model="ruleForm.quxiaoyuanyin" 
					placeholder="取消原因" clearable :readonly="ro.quxiaoyuanyin"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="取消时间" prop="quxiaoshijian">
				<el-date-picker
					:disabled="ro.quxiaoshijian"
					value-format="yyyy-MM-dd HH:mm:ss"
					v-model="ruleForm.quxiaoshijian" 
					type="datetime"
					placeholder="取消时间">
				</el-date-picker>
			</el-form-item>
			<el-form-item class="add-item" label="货主账号" prop="huozhuzhanghao">
				<el-input v-model="ruleForm.huozhuzhanghao" 
					placeholder="货主账号" clearable :readonly="ro.huozhuzhanghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="货主姓名" prop="huozhuxingming">
				<el-input v-model="ruleForm.huozhuxingming" 
					placeholder="货主姓名" clearable :readonly="ro.huozhuxingming"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="联系方式" prop="lianxifangshi">
				<el-input v-model="ruleForm.lianxifangshi" 
					placeholder="联系方式" clearable :readonly="ro.lianxifangshi"></el-input>
			</el-form-item>

			<el-form-item class="add-btn-item">
				<el-button class="submitBtn"  type="primary" @click="onSubmit">
					<span class="icon iconfont icon-xiugai13"></span>
					<span class="text">确认</span>
				</el-button>
				<el-button class="closeBtn" @click="back()">
					<span class="icon iconfont icon-shanchu8"></span>
					<span class="text">取消</span>
				</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				id: '',
				baseUrl: '',
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
					quxiaoyuanyin : false,
					quxiaoshijian : false,
					huozhuzhanghao : false,
					huozhuxingming : false,
					lianxifangshi : false,
				},
				type: '',
				userTableName: localStorage.getItem('UserTableName'),
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
					quxiaoyuanyin: '',
					quxiaoshijian: '',
					huozhuzhanghao: '',
					huozhuxingming: '',
					lianxifangshi: '',
				},

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
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					chexing: [
					],
					jiage: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					yue: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					quxiaoyuanyin: [
					],
					quxiaoshijian: [
					],
					huozhuzhanghao: [
					],
					huozhuxingming: [
					],
					lianxifangshi: [
						{ validator: this.$validate.isMobile, trigger: 'blur' },
					],
				},
				centerType: false,
			};
		},
		computed: {
			sessionForm() {
				return JSON.parse(localStorage.getItem('sessionForm'))
			},



		},
		components: {
		},
		created() {
			if(this.$route.query.centerType){
				this.centerType = true
			}
			//this.bg();
			let type = this.$route.query.type ? this.$route.query.type : '';
			this.init(type);
			this.baseUrl = this.$config.baseUrl;
			this.ruleForm.quxiaoshijian = this.getCurDateTime()
		},
		methods: {
			getMakeZero(s) {
				return s < 10 ? '0' + s : s;
			},
			// 下载
			download(file ){
				window.open(`${file}`)
			},
			// 初始化
			init(type) {
				this.type = type;
				if(type=='cross'){
					var obj = JSON.parse(localStorage.getItem('crossObj'));
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
							this.ruleForm.huowutupian = obj[o]?obj[o].split(",")[0]:'';
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
						if(o=='quxiaoyuanyin'){
							this.ruleForm.quxiaoyuanyin = obj[o];
							this.ro.quxiaoyuanyin = true;
							continue;
						}
						if(o=='quxiaoshijian'){
							this.ruleForm.quxiaoshijian = obj[o];
							this.ro.quxiaoshijian = true;
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
					}
				}else if(type=='edit'){
					this.info()
				}
				// 获取用户信息
				this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						var json = res.data.data;
						if((json.huozhuzhanghao!=''&&json.huozhuzhanghao) || json.huozhuzhanghao==0){
							this.ruleForm.huozhuzhanghao = json.huozhuzhanghao;
							this.ro.huozhuzhanghao = true;
						}
						if((json.huozhuxingming!=''&&json.huozhuxingming) || json.huozhuxingming==0){
							this.ruleForm.huozhuxingming = json.huozhuxingming;
							this.ro.huozhuxingming = true;
						}
						if((json.lianxifangshi!=''&&json.lianxifangshi) || json.lianxifangshi==0){
							this.ruleForm.lianxifangshi = json.lianxifangshi;
							this.ro.lianxifangshi = true;
						}
					}
				});

				if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
					localStorage.removeItem('raffleType')
					setTimeout(() => {
						this.onSubmit()
					}, 300)
				}
			},

			// 多级联动参数
			// 多级联动参数
			async info() {
				await this.$http.get(`quxiaodingdan/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.ruleForm = res.data.data;
					}
				});
			},
			// 提交
			async onSubmit() {
				if(!this.ruleForm.id) {
					delete this.ruleForm.userid
				}
				await this.$refs["ruleForm"].validate(async valid => {
					if(valid) {
						if(this.type=='cross'){
							var statusColumnName = localStorage.getItem('statusColumnName');
							var statusColumnValue = localStorage.getItem('statusColumnValue');
							if(statusColumnName && statusColumnName!='') {
								var obj = JSON.parse(localStorage.getItem('crossObj'));
								if(!statusColumnName.startsWith("[")) {
									for (var o in obj){
										if(o==statusColumnName){
											obj[o] = statusColumnValue;
										}
									}
									var table = localStorage.getItem('crossTable');
									await this.$http.post(table+'/update', obj).then(res => {});
								}
							}
						}

						let changeType = true
						let errMsg = ''
						let hasBackType = false
						if(this.type=='cross') {
							if(this.ruleForm.dingdanbianhao) {
								await this.$http.post('deleteColumn/yunshudingdan',{
								csuConditionColumn: 'dingdanbianhao',
								csuConditionColumnValue: this.ruleForm.dingdanbianhao
								}).then(rs=>{
									hasBackType = true
								})
							}
						}
						await this.$http.post(`quxiaodingdan/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(async res => {
							if (res.data.code == 0) {
								await this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										if(hasBackType) {
											this.$router.go(-2);
										}else {
											this.$router.go(-1);
										}
										
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
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
				this.$router.go(-1);
			},
			huowutupianUploadChange(fileUrls) {
				this.ruleForm.huowutupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
			},
		}
	};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.add-update-preview {
		padding: 20px 7% 40px;
		margin: 10px auto;
		background: none;
		width: 100%;
		position: relative;
		.add-update-form {
			border: 2px dashed #eee;
			border-radius: 0;
			padding: 40px 20% 20px 10%;
			background: #fff;
			width: 100%;
			position: relative;
			.add-item.el-form-item {
				padding: 0;
				margin: 0 0 24px;
				background: none;
				::v-deep .el-form-item__label {
					padding: 0 10px 0 0;
					color: #333;
					white-space: nowrap;
					font-weight: 500;
					width: 200px;
					font-size: 16px;
					line-height: 40px;
					text-align: right;
				}
				::v-deep .el-form-item__content {
					margin-left: 200px;
				}
				.el-input {
					width: 100%;
				}
				.el-input ::v-deep .el-input__inner {
					border: 0px dashed #ddd;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					outline: none;
					color: #666;
					width: 100%;
					font-size: 16px;
					border-width: 0 0 1px;
					height: 40px;
				}
				.el-input ::v-deep .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 4px;
					padding: 0 12px;
					box-shadow: none;
					outline: none;
					color: rgba(85, 85, 127, 1.0);
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number ::v-deep .el-input__inner {
					text-align: left;
					border: 0px dashed #ddd;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					outline: none;
					color: #666;
					width: 100%;
					font-size: 16px;
					border-width: 0 0 1px;
					height: 40px;
				}
				.el-input-number ::v-deep .is-disabled .el-input__inner {
					text-align: left;
					border: 0;
					cursor: not-allowed;
					border-radius: 4px;
					padding: 0 12px;
					box-shadow: none;
					outline: none;
					color: rgba(85, 85, 127, 1.0);
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number ::v-deep .el-input-number__decrease {
					display: none;
				}
				.el-input-number ::v-deep .el-input-number__increase {
					display: none;
				}
				.el-select {
					width: 100%;
				}
				.el-select ::v-deep .el-input__inner {
					border: 0px dashed #ddd;
					border-radius: 0px;
					padding: 0 10px;
					box-shadow: none;
					outline: none;
					color: rgba(64, 158, 255, 1);
					width: 100%;
					font-size: 14px;
					border-width: 0 0 1px;
					height: 40px;
				}
				.el-select ::v-deep .is-disabled .el-input__inner {
					border: 0;
					cursor: not-allowed;
					border-radius: 4px;
					padding: 0 10px;
					box-shadow: none;
					outline: none;
					color: rgba(85, 85, 127, 1.0);
					background: #eee;
					width: 100%;
					font-size: 14px;
					height: 40px;
				}
				.el-date-editor {
					width: 100%;
				}
				.el-date-editor ::v-deep .el-input__inner {
					border: 0px dashed #ddd;
					border-radius: 0px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					outline: none;
					color: #666;
					width: 100%;
					font-size: 16px;
					border-width: 0 0 1px;
					height: 40px;
				}
				.el-date-editor ::v-deep .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 4px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					outline: none;
					color: #666;
					background: #eee;
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				::v-deep .el-upload--picture-card {
					background: transparent;
					border: 0;
					border-radius: 0;
					width: auto;
					height: auto;
					line-height: initial;
					vertical-align: middle;
				}
				::v-deep .upload .upload-img {
					border: 1px dashed #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					width: 80px;
					font-size: 26px;
					line-height: 80px;
					text-align: center;
					height: 80px;
				}
				::v-deep .el-upload-list .el-upload-list__item {
					border: 1px dashed #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					width: 80px;
					font-size: 26px;
					line-height: 80px;
					text-align: center;
					height: 80px;
					font-size: 14px;
					line-height: 1.8;
				}
				::v-deep .el-upload .el-icon-plus {
					border: 1px dashed #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					width: 80px;
					font-size: 26px;
					line-height: 80px;
					text-align: center;
					height: 80px;
				}
				::v-deep .el-upload__tip {
					color: #666;
					font-size: 16px;
				}
				.el-textarea ::v-deep .el-textarea__inner {
					border: 1px dashed #ddd;
					border-radius: 0px;
					padding: 12px;
					box-shadow: none;
					outline: none;
					color: #666;
					width: 100%;
					font-size: 16px;
					height: auto;
				}
				.el-textarea ::v-deep .el-textarea__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 4px;
					padding: 12px;
					box-shadow: none;
					outline: none;
					color: rgba(85, 85, 127, 1.0);
					width: 100%;
					font-size: 16px;
					height: auto;
				}
				::v-deep .el-input__inner::placeholder {
					color: #123;
					font-size: 16px;
				}
				::v-deep textarea::placeholder {
					color: #123;
					font-size: 16px;
				}
				.editor {
					background-color: #fff;
					border-radius: 0;
					padding: 0;
					box-shadow: none;
					margin: 0;
					width: 100%;
					border-color: #ccc;
					border-width: 0;
					border-style: solid;
					height: auto;
				}
				.editor ::v-deep.ql-toolbar {
					border: 0px dashed #ddd;
					background: none;
					border-width: 1px 1px 0;
				}
				.editor ::v-deep.ql-container {
					border: 1px dashed #ddd;
					background: none;
					min-height: 180px;
				}
				.editor ::v-deep.ql-container .ql-blank::before {
					color: #999;
				}
				.upload-img {
					object-fit: cover;
					width: 120px;
					height: 120px;
				}
				.viewBtn {
					border: 0;
					cursor: pointer;
					padding: 0 20px;
					margin: 0;
					color: #fff;
					display: inline-block;
					font-size: 14px;
					line-height: 34px;
					border-radius: 4px;
					outline: none;
					background: #6aac5a;
					width: auto;
					height: 34px;
				}
				.viewBtn:hover {
					opacity: 0.7;
				}
				.unviewBtn {
					border: 0;
					cursor: pointer;
					padding: 0 20px;
					margin: 0;
					color: #fff;
					display: inline-block;
					font-size: 14px;
					line-height: 34px;
					border-radius: 4px;
					outline: none;
					background: #999;
					width: auto;
					height: 34px;
				}
				.unviewBtn:hover {
					opacity: 0.8;
				}
			}
			.add-btn-item {
				padding: 0;
				margin: 20px auto;
				width: 100%;
				text-align: center;
				.submitBtn {
					border: 0;
					cursor: pointer;
					border-radius: 0px;
					padding: 0 25px;
					margin: 0 20px 0 0;
					outline: none;
					background: #6aac5a;
					display: inline-block;
					width: auto;
					font-size: 14px;
					line-height: 40px;
					height: 40px;
					.icon {
						color: rgba(255, 255, 255, 1);
					}
					.text {
						color: rgba(255, 255, 255, 1);
						font-size: 16px;
					}
				}
				.submitBtn:hover {
					opacity: 0.7;
					.icon {
						color: #fff;
					}
					.text {
						color: #fff;
					}
				}
				.closeBtn {
					border: 0;
					cursor: pointer;
					padding: 0 15px;
					margin: 0 20px 0 0;
					display: inline-block;
					font-size: 16px;
					line-height: 40px;
					border-radius: 0px;
					outline: none;
					background: #cb515120;
					width: auto;
					min-width: 100px;
					height: 40px;
					.icon {
						color: #cb5151;
						font-size: 18px;
					}
					.text {
						color: #cb5151;
						font-size: 16px;
					}
				}
				.closeBtn:hover {
					opacity: 0.7;
					.icon {
					}
					.text {
					}
				}
			}
		}
	}
	.el-date-editor.el-input {
		width: auto;
	}
</style>
